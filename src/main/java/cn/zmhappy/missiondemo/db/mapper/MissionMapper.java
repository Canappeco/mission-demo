package cn.zmhappy.missiondemo.db.mapper;

import cn.zmhappy.missiondemo.db.domain.Mission;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

//    @Insert("insert into t_mission(user_id, cond, state) values(#{userId}, #{cond}, #{state})")
    @InsertProvider(type = sqlBuilder.class,method = "insertBatch")
    void insertMissionBatch(@Param("List") List<Mission> list);

    class sqlBuilder {
        public String insertBatch(Map<String, Object> map) {
            List<Mission> list = (List<Mission>)map.get("List");
            StringBuilder sql = new StringBuilder();
            sql.append("insert into t_mission(user_id, cond, state) values ");
            for (int i = 0; i < list.size(); i++) {
                sql.append("(#{List["+i+"].userId}, #{List["+i+"].cond}, #{List["+i+"].state})");
                if (i != list.size()-1) {
                    sql.append(", ");
                } else {
                    sql.append(";");
                }
            }
            System.out.println(sql.toString());
            return sql.toString();
        }
    }
}
