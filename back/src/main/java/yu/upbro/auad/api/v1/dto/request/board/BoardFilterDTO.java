package yu.upbro.auad.api.v1.dto.request.board;

import lombok.Data;
import yu.upbro.auad.api.v1.entity.type.BoardType;

@Data
public class BoardFilterDTO {
    private int count;
    private BoardType boardType;
}