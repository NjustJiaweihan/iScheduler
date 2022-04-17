create table user(
    id int primary key not null auto_increment comment 'id',
    name varchar(32) not null default '' comment '昵称',
    ctime datetime not null default CURRENT_TIMESTAMP comment 'ctime'
) engine=InnoDB default charset=utf8mb4 comment '用户表';