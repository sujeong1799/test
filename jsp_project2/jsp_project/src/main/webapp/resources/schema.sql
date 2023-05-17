use mysql;

create user 'jspuser'@'localhost' identified by 'mysql';
grant all privileges on jspdb.* to 'jspuser'@'localhost' with grant option;
flush privileges;

create database jspdb;


-- 2023-05-12
Create table member(
id varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
age int,
reg_date datetime default now(),
last_login datetime,
primary key(id));


-- 2023-05-16
Create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
content text,
reg_date datetime default now(),
Primary key(bno));


-- 2023-05-17
alter table board add count int default 0;
