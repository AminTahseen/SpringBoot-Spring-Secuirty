create database sts;
use sts;
show tables;

create table tbl_user(uid int primary key auto_increment,username varchar(50),pass varchar(500));
insert into tbl_user values(2,"user2","$2a$10$uyvxpAlgfTr3DXribfb39OMnEjW1ogfLz2hYa9s./o161mo7wdu7a"); #pass:User123
insert into tbl_user values(3,"user3","$2a$10$LtO9grQ4w9iJ6KU1uIe1y.EELYB0wgjhXnMKZZraNkNhJuJi464la"); #pass:user3
select * from tbl_user;
desc tbl_user;

