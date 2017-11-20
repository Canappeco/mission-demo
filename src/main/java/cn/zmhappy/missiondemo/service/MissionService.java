package cn.zmhappy.missiondemo.service;

import cn.zmhappy.missiondemo.db.domain.Mission;

import java.util.List;
import java.util.Map;

public interface MissionService {

    public List<Mission> findList();

    public void findName(Map<String, Object> map);

    public List<Mission> findWaitList();

    public void insertMission(Mission mission);

    public void finishMission(Mission mission);

    public Mission findLastMission();
}
