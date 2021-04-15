begin
   execute immediate 'drop table book';
exception
   when others then null;
end;
/

create table book(
id number(10) not null,
title VARCHAR2(45) not null,
category VARCHAR2(45) not null,
author VARCHAR2(45) not null,
price binary_double not null,
primary key(id)
);  

create sequence book_seq start with 1 increment by 1;

create or replace trigger book_seq_tr
 before insert on book for each row
 when (new.id is null)
begin
 select book_seq.nextval into :new.id from dual;
end;
/

insert into book(title, category, author, price) values ('Shout', 'Poetry', 'Laurie', 500);
