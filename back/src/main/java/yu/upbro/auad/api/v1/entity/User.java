package yu.upbro.auad.api.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
@Builder
@AllArgsConstructor
public class User {
    @Id
    private ObjectId _id;
    private String studentId;
    private String pwd;
    private String type;
    private String name;
}
