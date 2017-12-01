CREATE TABLE t_mission
(
   id int auto_increment PRIMARY KEY,
   user_id int,
   cond varchar(100),
   state varchar(100)
);

insert into t_mission(user_id, cond, state) values(1, "none", "waiting");
insert into t_mission(user_id, cond, state) values(1, "none", "waiting");
insert into t_mission(user_id, cond, state) values(1, "none", "waiting");
insert into t_mission(user_id, cond, state) values(1, "none", "waiting");
insert into t_mission(user_id, cond, state) values(1, "none", "finished");


CREATE TABLE t_mission
(
   id int auto_increment PRIMARY KEY,
   user_id varchar(50),
   description varchar(500),
   result varchar(2000),
   state varchar(50),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);