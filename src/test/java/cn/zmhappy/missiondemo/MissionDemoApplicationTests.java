package cn.zmhappy.missiondemo;

import cn.zmhappy.missiondemo.db.domain.Mission;
import cn.zmhappy.missiondemo.service.MissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionDemoApplicationTests {

	@Autowired
	private MissionService missionService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void batchTest() {
		List<Mission> list = new ArrayList<>();
		for (int i = 0; i < 100 ; i++) {
			Mission mission = new Mission();
			mission.setUserId(i);
			mission.setCond("cond" + i);
			list.add(mission);
		}
		System.out.println("=====begin=====");
		missionService.insertMissionBatch(list);
		System.out.printf("======end======");

 	}

}
