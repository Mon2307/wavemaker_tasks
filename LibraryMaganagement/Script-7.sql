use LibraryManagement;
create table user_details(id int primary key,name varchar(20),gender varchar(20),dept varchar(20));

create table book_details(book_id int primary key,book_name varchar(20),author_name varchar(20),lang varchar(20));

create table bookanduser(id int primary key,userid int ,bookid int ,issuedate date, returndate date , renew date,foreign key(userid) references user_details(id),foreign key(bookid) references book_details(book_id));

insert into user_details values(5,"Shanaya","female","IT");

select * from user_details;

insert into book_details values(1005,'Jade Lady Burning',' Martin Limon',"English");



insert into bookanduser values(15,5,1005,"2003-07-24","2003-08-12","2003-08-05");