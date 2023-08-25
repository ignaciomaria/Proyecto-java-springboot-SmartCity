DROP DATABASE IF EXISTS `bd-SmartCity-grupo15` ;
CREATE DATABASE  IF NOT EXISTS `bd-SmartCity-grupo15`;
USE `bd-SmartCity-grupo15`;

select* from dispositivo;
select* from evento;
select* from sensorHumedad;
select* from sensorLuz;
select* from user;
select* from user_role;
update dispositivo set activo=true where id=4;
delete from evento where id=4;

insert into evento(id,descripcion,iddispositivo)values(1,"Se encienden los aspersores",3); 
insert into evento(id,descripcion,iddispositivo)values(2,"Se encienden las luces",2); 

insert into user(id,enabled,password,username)values(1,true,"1234","Ignacio Maria"); 
insert into user(id,enabled,password,username)values(2,true,"5678","Cristian Sandoval"); 
insert into user_role(id,role,user_id)values(1,"Admin",1); 
insert into user_role(id,role,user_id)values(2,"Auditor",2); 