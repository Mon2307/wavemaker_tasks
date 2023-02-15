use Library;

create table category(id int primary key,category varchar(50));

create table langauage(id int primary key,language_name varchar(20));

create table gender(id int primary key,Gender varchar(10));

show tables;

create table book_details(book_id int primary key,name varchar(50),booktype_id int,author_name varchar(20),publication varchar(50),language_id int,cost bigint,isavailable boolean,total_copies int,shelf_name varchar(10),foreign key(booktype_id) references category(id),foreign key(language_id) references langauage(id));

create table user_details(id int primary key,name varchar(30),first_year year,final_year year,degree_name varchar(10),branch varchar(20),issuedid int unique key,dob date,genderid int);

create table bookanduser (id int auto_increment primary key,user_id int,book_id int,isbooklost boolean,dues int,issue_date date,return_date date,UNIQUE KEY (user_id, book_id));

create table librarian(id int primary key,name varchar(20),qualification varchar(20),joining_date date,ending_date date,dob date,genderid int,foreign key(genderid) references gender(id));

insert into category values(6,"Mystery");

insert into langauage values(16,"Japanese");


insert into gender values(113,"Other");


select * from book_details;


select * from category;


select * from langauage;


select * from user_details;


alter table user_details drop column issuedid;


create table bookanduser (id int auto_increment primary key,user_id int,book_id int,isbooklost boolean,dues int,issue_date date,return_date date,foreign key(user_id) references user_details(id),foreign key(book_id) references book_details(book_id), UNIQUE KEY (user_id, book_id));

insert into book_details values(1006," Jade Lady Burning",6," Martin Limon","Home Publication",15,650,true,5,"A6");


insert into user_details values(205,"Hritik",2018,2021,"B.tech","Electrical","2000-12-23",1);


insert into bookanduser values(56,205,1004,false,0,"2022-07-01","2022-07-13");


drop table bookanduser;


drop table user_details;

create table user_details(id int primary key,name varchar(30),first_year year,final_year year,degree_name varchar(10),branch varchar(20),dob date,genderid int,foreign key(genderid) references gender(id));

create table bookanduser (id int auto_increment primary key,user_id int,book_id int,isbooklost boolean,dues int,issue_date date,return_date date,UNIQUE KEY (user_id, book_id));


insert into user_details values(206,"Sahiti",2019,2022,"M.tech","IT","1996-08-24",112);

use library;

drop table bookanduser;

create table bookanduser (id int auto_increment primary key,user_id int,book_id int,isbooklost boolean,dues int,issue_date date,return_date date,UNIQUE KEY (user_id, book_id),foreign key(user_id) references user_details(id),foreign key(book_id) references book_details(book_id));


insert into bookanduser values(57,205,1005,false,0,"2022-02-12","2021-02-20");

insert into librarian values(25,"Mrs.Anuradha","Msc","2015-12-01","2016-12-10","1995-12-09",112);
select * from librarian;


