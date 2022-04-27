package yu.upbro.auad.api.v1.dto.request.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardDTO {
    private String boardId;
    private String title;
    private String context;
    private List<MultipartFile> images;
}