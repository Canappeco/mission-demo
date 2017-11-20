package cn.zmhappy.missiondemo.controller;

import cn.zmhappy.missiondemo.db.domain.Mission;
import cn.zmhappy.missiondemo.service.MissionService;
import cn.zmhappy.missiondemo.util.MissionUtil;
import cn.zmhappy.missiondemo.util.ResultVOUtil;
import cn.zmhappy.missiondemo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

@RestController
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @Autowired
    private MissionUtil missionUtil;

    @RequestMapping("/findlist")
    public ResultVO findMissionList() {
        try {
            return ResultVOUtil.success(missionService.findList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "fail");
        }
    }

    @RequestMapping("/setMission")
    public ResultVO startMission(HttpServletRequest request) {
        try {
            Mission mission;
            BlockingQueue<Mission> missions = missionUtil.getMissionList();
            if (missions.size() <= 10) {
                mission = new Mission();
                mission.setCond(request.getParameter("cond"));
                mission.setState("waiting");
                mission.setUserId(Integer.parseInt(request.getParameter("user_id")));
                return ResultVOUtil.success(missionUtil.setMissionInList(mission));
            } else {
                return ResultVOUtil.error(0, "too many mission, please wait");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "fail");
        }
    }

    @RequestMapping("/findname")
    public ResultVO findname(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            missionService.findName(map);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(0, "fail");
        }
    }

}
