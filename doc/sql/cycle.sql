create table cycle(
    id int primary key not null auto_increment comment 'id',
    user_id int not null default 0 comment '用户id',
    week_seq int not null default 0 comment '周期序号',
    start_date datetime not null default CURRENT_TIMESTAMP comment '开始日期',
    end_date datetime not null default CURRENT_TIMESTAMP comment '结束日期',
    day_count int not null default 0 comment '周期天数',
    ctime datetime not null default CURRENT_TIMESTAMP comment 'ctime'
) engine=InnoDB default charset=utf8mb4 comment '周期表';