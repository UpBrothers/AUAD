package yu.upbro.auad.api.v1.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.upbro.auad.api.v1.dto.request.board.BoardFilterDTO;
import yu.upbro.auad.api.v1.dto.request.board.BoardUpdateDTO;
import yu.upbro.auad.api.v1.entity.Board;
import yu.upbro.auad.api.v1.service.BoardService;
import yu.upbro.auad.api.v1.service.LoginService;

import java.util.List;

@Api(value = "게시물 API", tags = {"Board API"})
@RestController
@RequestMapping(path="/api/v1/board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;
//    private final LoginService loginService;

    @Autowired
    public BoardController(BoardService boardService /*, LoginService loginService */){
        this.boardService = boardService;
//        this.loginService = loginService;
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
        logger.info("[selectBoardList] pageNum : {}, boardType : {}"
                /* ,boardFilterDTO.getCount(), boardFilterDTO.getBoardType() */ );

        List<Board> boardList = boardService.selectBoardList();

        return ResponseEntity.status(HttpStatus.OK).body(boardList);
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "글 등록")
    public ResponseEntity insertBoard(
            @RequestBody
            @ApiParam(value="글 등록/수정 DTO", required = true)
                    BoardUpdateDTO boardUpdateDTO
    ){
        logger.info("[writeBoard] title : {} , context : {}, [images].size() : {} ",
                boardUpdateDTO.getTitle(), boardUpdateDTO.getContext() /*, boardUpdateDTO.getImages().size()*/);

        Board board = boardService.insertBoard(boardUpdateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(board);
    }
}
