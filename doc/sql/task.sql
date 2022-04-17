create table task(
    id int primary key not null auto_increment comment 'id',
    user_id int not null default 0 comment '用户id',
    cycle_id int not null default 0 comment '周期id',
    task_name varchar(16) not null default '' comment '任务名',
    color tinyint not null default 0 comment '任务颜色',
    use_day varchar(256) not null default '' comment '任务使用的日期(json)',
    ctime datetime not null default CURRENT_TIMESTAMP comment 'ctime'
) engine=InnoDB default charset=utf8mb4 comment '任务表';