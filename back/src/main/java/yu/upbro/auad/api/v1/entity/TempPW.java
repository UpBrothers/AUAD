package yu.upbro.auad.api.v1.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import yu.upbro.auad.api.v1.entity.type.UserType;

@Data
@Builder
@RedisHash(value="tempPW", timeToLive=10)
public class TempPW{
    @Id
    private String userId;
    private String tempPW;
    private UserType userType;
}