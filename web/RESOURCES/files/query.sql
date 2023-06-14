/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Admin
 * Created: 14 jun. 2023
 */

create database sistemasoaputp
go
use sistemasoaputp
go
create table cliente(
id int identity(1,1) not null primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
correo varchar(30) unique not null,
dni varchar(30) unique not null
)
go
insert into cliente values('Prueba1','Prueba1','Prueba1','Prueba1')
go
select * from cliente