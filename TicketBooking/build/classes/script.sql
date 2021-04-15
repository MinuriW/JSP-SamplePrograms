begin
   execute immediate 'drop table seating_section';
exception
   when others then null;
end;
/

create table seating_section(id number(10) GENERATED ALWAYS AS IDENTITY not null 
primary key,seating_type varchar2(255) not null,
ticket_cost binary_double not null,
number_of_seats number(10) not null);

insert into seating_section(seating_type,ticket_cost,number_of_seats)values('Platinum',280,40);
insert into seating_section(seating_type,ticket_cost,number_of_seats)values('Gold',223,50);
insert into seating_section(seating_type,ticket_cost,number_of_seats)values('Silver',167,30);



