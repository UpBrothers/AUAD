package yu.upbro.auad.api.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yu.upbro.auad.api.v1.entity.Board;


@Repository
public interface BoardRepository extends MongoRepository<Board, String> {
}