# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table language (
  id                            integer auto_increment not null,
  en                            varchar(255),
  fr                            varchar(255),
  constraint pk_language primary key (id)
);


# --- !Downs

drop table if exists language;

