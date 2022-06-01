package yu.upbro.auad.api.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yu.upbro.auad.api.v1.entity.TempPW;

@Repository
public interface TempPWRedisRepository extends CrudRepository<TempPW, String> {
}
