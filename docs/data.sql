drop table if exists person;
create table person (
  id bigint(20) not null primary key auto_increment comment '主键',
  name varchar(100) not null comment '名字',
  age int(3) not null comment '年龄',
  birthday timestamp not null comment '生日'
);

drop table if exists clazz;
create table clazz(
  id bigint(20) not null primary key auto_increment comment '主键',
  code varchar(10) not null comment '班机编码'
);


drop table if exists student;
create table student(
  id bigint(20) not null primary key auto_increment comment '主键',
  clazz_id bigint(20) not null ,
  name varchar(100) not null comment '名字',
  age int(3) not null comment '年龄',
  birthday timestamp not null comment '生日',
  foreign key (clazz_id) references clazz(id)
);