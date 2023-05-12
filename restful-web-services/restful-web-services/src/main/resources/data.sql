insert into user_details(id,birth_date,name)
values(1001,current_date(),'snehal');
insert into user_details(id,birth_date,name)
values(1002,current_date(),'pooja');
insert into user_details(id,birth_date,name)
values(1003,current_date(),'chetan');

insert into posts(id,description,user_id)
values(2001,'I want to learn java',1001);


insert into posts(id,description,user_id)
values(2002,'I want to learn AWS',1001);


insert into posts(id,description,user_id)
values(2003,'I want to learn AWS',1002);

insert into posts(id,description,user_id)
values(2004,'I want to learn AWS',1003);