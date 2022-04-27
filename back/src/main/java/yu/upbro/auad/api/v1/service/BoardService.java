package yu.upbro.auad.api.v1.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.upbro.auad.api.v1.dto.request.board.BoardDTO;
import yu.upbro.auad.api.v1.dto.request.board.BoardFilterDTO;
import yu.upbro.auad.api.v1.dto.request.board.BoardUpdateDTO;
import yu.upbro.auad.api.v1.entity.Board;
import yu.upbro.auad.api.v1.entity.User;
import yu.upbro.auad.api.v1.repository.BoardRepository;
import yu.upbro.auad.api.v1.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, UserRepository userRepository){
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public Board selectBoard(String boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(RuntimeException::new);

        return board;
    }

    public List<Board> selectBoardList(){
        return boardRepository.findAll();
    }

    public Board insertBoard(BoardUpdateDTO boardUpdateDTO){
        // TODO findByStudentID by HTTP Header's user token -> not found USER
        // throw new UserNotFoundException;
        User user = userRepository.findByStudentId(boardUpdateDTO.getOwner())
                .orElseThrow(RuntimeException::new); // TODO NotFoundUser Exception Handling

        // if ( user.getUserType != ADMIN ) -> Failed;
        // throw new Forbidden Exception;

        Board board = Board.builder()
                .title(boardUpdateDTO.getTitle())
                .context(boardUpdateDTO.getContext())
                .date(new Date())
                .owner(user)
                .build();

        return boardRepository.save(board);
    }

    public Board modifyBoard(BoardDTO boardDTO){
        //

        Board board = boardRepository.findById(boardDTO.getBoardId())
                .orElseThrow(RuntimeException::new);
        // TODO NotFoundBoardException;

        // TODO boardDTO's user == Board's user
        // throw new NotOwnerException

        board.setTitle(boardDTO.getBoardId());
        return boardRepository.save(board);
    }
}
