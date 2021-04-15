begin
   execute immediate 'drop table airport';
exception
   when others then null;
end;
/

create table airport(
id number(10) GENERATED ALWAYS AS IDENTITY not null,
iata_airport_code VARCHAR2(45) not null,
name VARCHAR2(45) not null,
city VARCHAR2(45) not null,
country_name VARCHAR2(45) not null,
primary key(id));

insert into airport(iata_airport_code,name,city,country_name)values('COK','Cochin International Airport','Cochin','India');
insert into airport(iata_airport_code,name,city,country_name)values('BNE','Brisbane Airport','Brisbane','Australia');