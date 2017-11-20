package cn.zmhappy.missiondemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "cn.zmhappy.missiondemo.db.mapper")
@EnableCaching
@EnableScheduling
public class MissionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionDemoApplication.class, args);
	}
}
