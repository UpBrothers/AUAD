package yu.upbro.auad.api.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import yu.upbro.auad.api.v1.entity.type.UserType;

@Getter
@Document(collection = "user")
@Builder
@AllArgsConstructor
public class User {
    @Id
    private String _id;
    private String studentId;
    private String pwd;
    private UserType type;
    private String name;
}
