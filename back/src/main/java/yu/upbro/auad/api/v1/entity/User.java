package yu.upbro.auad.api.v1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
@NoArgsConstructor
public class User {
    private String studentId;
    private String pwd;
    private String type;
    private String name;
}
