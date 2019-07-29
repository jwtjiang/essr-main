package scheduled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"eley.dao"})
public class EssrScheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(EssrScheduledApplication.class, args);
	}

}
