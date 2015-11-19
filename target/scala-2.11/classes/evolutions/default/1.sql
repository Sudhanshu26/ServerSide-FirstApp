# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table chatmessages (
  Id                        bigint auto_increment not null,
  messagefrom               varchar(255),
  message                   varchar(255),
  messageto                 varchar(255),
  DATETIME                  varchar(255),
  constraint pk_chatmessages primary key (Id))
;

create table User (
  Id                        bigint auto_increment not null,
  UserName                  varchar(255),
  constraint pk_User primary key (Id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table chatmessages;

drop table User;

SET FOREIGN_KEY_CHECKS=1;

