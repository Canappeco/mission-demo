package cn.zmhappy.missiondemo.db.dao;

import cn.zmhappy.missiondemo.db.domain.Mission;
import cn.zmhappy.missiondemo.db.mapper.MissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissionDao {

    @Autowired
    private MissionMapper missionMapper;

    public List<Mission> findList() {
        return missionMapper.findList();
    }

    public List<Mission> findWaitList() {
        return missionMapper.findWaitList();
    }

    public void InsertMission(Mission mission) {
        missionMapper.insertMission(mission);
    }

    public void finishMission(Mission mission) {
        missionMapper.finishMission(mission);
    }

    public Mission findLastMission() {
        return missionMapper.findLastMission();
    }

    public void insertMissionBatch(List<Mission> list) {
        missionMapper.insertMissionBatch(list);
    }
}
