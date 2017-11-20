package cn.zmhappy.missiondemo.util;

import cn.zmhappy.missiondemo.db.domain.Mission;
import cn.zmhappy.missiondemo.service.MissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@Slf4j
public class MissionUtil{

    @Autowired
    private MissionService missionService;

    private BlockingQueue<Mission> missionList = new LinkedBlockingQueue<>(500);

    @PostConstruct
    private void init() {
        List<Mission> list = missionService.findWaitList();
        for (Mission mission : list) {
            missionList.offer(mission);
        }
        Thread threadMission = new Thread(new ThreadMission());
        threadMission.start();
    }

    public BlockingQueue<Mission> setMissionInList(Mission mission) {
        missionService.insertMission(mission);
        mission = missionService.findLastMission();
        this.missionList.offer(mission);
        return this.missionList;
    }

    public BlockingQueue<Mission> getMissionList() {
        return this.missionList;
    }

    public boolean runMission(Mission mission) {
        try {
            Thread.sleep(10000);
            mission.setState("finished");
            missionService.finishMission(mission);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private class ThreadMission implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    if (missionList.size() == 0) {
                        log.info("[stop ] No mission waiting in list ... sleeping ...");
                        Thread.sleep(1000);
                    } else {
                        Mission mission = missionList.poll();
                        log.info("[start] running mission --- " + mission.getId());
                        runMission(mission);
                        log.info("[end  ] runover mission --- " + mission.getId());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
