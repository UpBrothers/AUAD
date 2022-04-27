package yu.upbro.auad.api.v1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import yu.upbro.auad.api.v1.dto.request.board.BoardDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "board")
@Builder
public class Board {
    private User owner;
    @Id
    private String _id;
    private String title;
    private String context;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private List<String> images;

    private void updateBoard(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.context = boardDTO.getContext();

        // Upload new Images, Delete older Images
        this.images = new ArrayList<String>();
    }
}