package cn.zmhappy.missiondemo.db.domain;

import lombok.Data;

@Data
public class Mission {

    private Integer id;
    private Integer userId;
    private String cond;
    private String state;

}
