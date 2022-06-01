package yu.upbro.auad.api.v1.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.upbro.auad.api.v1.dto.request.board.BoardUpdateDTO;
import yu.upbro.auad.api.v1.entity.Board;
import yu.upbro.auad.api.v1.service.BoardService;
import yu.upbro.auad.api.v1.utils.S3Uploader;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Api(value = "게시물 API", tags = {"Board API"})
@RestController
@RequestMapping(path="/api/v1/board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;
    private final S3Uploader s3Uploader;

    @Autowired
    public BoardController(BoardService boardService, S3Uploader s3Uploader){
        this.boardService = boardService;
        this.s3Uploader = s3Uploader;
    }

    @GetMapping(path = "/{boardId}")
    @ApiOperation(value = "글 조회", notes = "필터링 적용 전, 모든 Board List")
    public ResponseEntity selectBoard(
            @PathVariable("boardId")
                    String boardId){
        logger.info("[viewBoard] boardId : {}", boardId);

        Board board = boardService.selectBoard(boardId);

        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @GetMapping(path="/")
    @ApiOperation(value="글 목록 조회", notes = "글 목록 출력")
    public ResponseEntity selectBoardList(
//            @RequestParam
//                BoardFilterDTO boardFilterDTO
    ){
        // TODO Pagination
        logger.info("[selectBoardList] pageNum : {}, boardType : {}"
                /* ,boardFilterDTO.getCount(), boardFilterDTO.getBoardType() */ );

        List<Board> boardList = boardService.selectBoardList();

        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "글 등록")
    public ResponseEntity insertBoard(
            @ApiParam(value="글 등록 DTO", required = true)
                    BoardUpdateDTO boardUpdateDTO
    ){
        logger.info("[writeBoard] title : {} , context : {}, [images].size() : {} ",
                boardUpdateDTO.getTitle(), boardUpdateDTO.getContext() /*, boardUpdateDTO.getImages().size()*/);

        List<String> imageList;
        try {
            imageList = s3Uploader.upload(boardUpdateDTO.getImages(), new Date().toString());
        } catch (IOException e) {
            // TODO Exception Handling
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미지 업로드 실패");
        }
        boardUpdateDTO.setImageLinks(imageList);

        Board board = boardService.insertBoard(boardUpdateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(board);
    }

    @PutMapping(path="/")
    @ApiOperation(value = "글 수정")
    public ResponseEntity updateBoard(
            @RequestBody
            @ApiParam(value="글 수정 DTO", required = true)
                    BoardUpdateDTO boardUpdateDTO
    ){
        logger.info("[updateBoard] boardUpdateDTO : {}", boardUpdateDTO);

        Board board = boardService.updateBoard(boardUpdateDTO);;

        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @DeleteMapping(path="/")
    @ApiOperation(value= "글 삭제")
    public ResponseEntity deleteBoard(
            @RequestBody // token
                    String boardId,
            @RequestBody
                    String studentId
    ){
        logger.info("[deleteBoard] BOARD NO.{} / {}", boardId);

        boardService.deleteBoard(boardId, studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
