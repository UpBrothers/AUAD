package yu.upbro.auad.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.upbro.auad.api.v1.entity.TempPW;
import yu.upbro.auad.api.v1.entity.type.UserType;
import yu.upbro.auad.api.v1.repository.TempPWRedisRepository;

import java.time.LocalDateTime;

@SpringBootTest
public class AuadApplicationTests {

	@Autowired
	private TempPWRedisRepository tempPWRedisRepository;

	@Test
	void redisInsert(){
		tempPWRedisRepository.deleteAll();

		TempPW tempPw = TempPW.builder()
				.userId("hwaning1")
				.tempPW("D35EB45D12GXY")
				.createdTime(LocalDateTime.now())
				.build();

		tempPWRedisRepository.save(tempPw);
	}
}
