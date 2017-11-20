package cn.zmhappy.missiondemo.service.impl;

import cn.zmhappy.missiondemo.db.dao.MissionDao;
import cn.zmhappy.missiondemo.db.domain.Mission;
import cn.zmhappy.missiondemo.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MissionServiceImpl implements MissionService{

    @Autowired
    private MissionDao missionDao;

    @Override
    public List<Mission> findList() {
        return missionDao.findList();
    }

    @Override
    public void findName(Map<String, Object> map) {
        System.out.println("findName() " + map.get("name"));
    }

    @Override
    public List<Mission> findWaitList() {
        List<Mission> list = missionDao.findWaitList();
        if (list == null) {
            return new ArrayList<>();
        } else {
            return list;
        }
    }

    @Override
    public void insertMission(Mission mission) {
        missionDao.InsertMission(mission);
    }

    @Override
    public void finishMission(Mission mission) {
        missionDao.finishMission(mission);
    }

    @Override
    public Mission findLastMission() {
        return missionDao.findLastMission();
    }
}
