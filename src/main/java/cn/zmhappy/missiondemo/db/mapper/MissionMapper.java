package cn.zmhappy.missiondemo.db.mapper;

import cn.zmhappy.missiondemo.db.domain.Mission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionMapper {

    @Select("select * from t_mission")
    List<Mission> findList();

    @Select("select * from t_mission where state = 'waiting'")
    List<Mission> findWaitList();

    @Insert("insert into t_mission(user_id, cond, state) values(#{userId}, #{cond}, #{state})")
    void insertMission(Mission mission);

    @Update("update t_mission set state = #{state} where id = #{id}")
    void finishMission(Mission mission);

    @Select("select * from t_mission order by id desc limit 1")
    Mission findLastMission();
}
