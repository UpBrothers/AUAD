package yu.upbro.auad.api.v1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.upbro.auad.api.v1.dto.request.board.BoardUpdateDTO;
import yu.upbro.auad.api.v1.entity.Board;
import yu.upbro.auad.api.v1.entity.User;
import yu.upbro.auad.api.v1.entity.type.UserType;
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
        // TODO Pagination
        return boardRepository.findAll();
    }

    public Board insertBoard(BoardUpdateDTO boardUpdateDTO){
        // TODO findByStudentID by HTTP Header's user token -> not found USER
        // throw new UserNotFoundException;
        User user = userRepository.findByStudentId(boardUpdateDTO.getStudentId())
                .orElseThrow(RuntimeException::new); // TODO NotFoundUser Exception Handling

        if(user.getType() != UserType.ADMIN)
            throw new RuntimeException(); // ForbiddenException

        Board board = Board.builder()
                .title(boardUpdateDTO.getTitle())
                .context(boardUpdateDTO.getContext())
                .date(new Date())
                .owner(user)
                .build();

        return boardRepository.save(board);
    }

    public Board updateBoard(BoardUpdateDTO boardUpdateDTO){
        Board board = boardRepository.findById(boardUpdateDTO.getBoardId())
                .orElseThrow(RuntimeException::new);
        // TODO NotFoundBoardException;

        logger.info("Board Owner : {} , Request User : {}", board.getOwner(), boardUpdateDTO.toString());
        if(!board.getOwner().getStudentId().equals(boardUpdateDTO.getStudentId())){ // TODO Compare HTTP Header by using Token
            throw new RuntimeException();
            // TODO Forbidden Exception;
        }
        board.setTitle(boardUpdateDTO.getTitle());
        board.setContext(boardUpdateDTO.getContext());
        // board.setImages(boardUpdateDTO.getImage());
        return boardRepository.save(board);
    }

    public void deleteBoard(String boardId, String studentId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(RuntimeException::new); // Not Found Exception

        if(board.getOwner().getStudentId().equals(studentId)){ // TODO Compare HTTP Header by using Token
            throw new RuntimeException();
            // TODO Forbidden Exception;
        }

        boardRepository.deleteById(boardId);
    }
}
