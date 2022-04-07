insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10001,'JPA',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10002,'Hibernet',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10003,'ORM',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10004,'dummy1',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10005,'dummy2',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10006,'dummy3',sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) 
values(10007,'dummy4',sysdate(),sysdate(), false);

insert into passport(id, number)
values(40001,'E123457');
insert into passport(id, number)
values(40002,'N123451');
insert into passport(id, number)
values(40003,'L236546');

insert into student(id,name,passport_id)
values(20001,'Pooja', 40001);
insert into student(id,name,passport_id)
values(20002,'Tanmoy', 40002);
insert into student(id,name,passport_id)
values(20003,'Samira', 40003);


insert into review(id, rating, description, course_id)
values(50001,'FIVE', 'Great', 10001);
insert into review(id, rating, description, course_id)
values(50002,'FIVE', 'Awesome', 10001);
insert into review(id, rating, description, course_id)
values(50003,'FIVE', 'Happy', 10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);