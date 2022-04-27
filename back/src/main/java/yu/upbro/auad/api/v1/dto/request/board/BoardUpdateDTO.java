package yu.upbro.auad.api.v1.dto.request.board;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("게시물 Update DTO")
public class BoardUpdateDTO {

    @ApiModelProperty(name="studentId", notes = "게시물 작성자", example="21611748")
    private String studentId;

    @ApiModelProperty(name="boardId", notes = "게시물 PK ( HEX ), Length : 24 )")
    private String boardId;

    @ApiModelProperty(name="title", notes = "게시물 제목")
    private String title;

    @ApiModelProperty(name="context", notes = "게시물 본문")
    private String context;

    @ApiModelProperty(name="images", notes = "게시물 등록 이미지 List")
    private List<String> images;
}
