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