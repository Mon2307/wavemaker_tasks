use librarymanagementproject;
create table category(id int primary key ,category varchar(50) not null);

create table langauage(id int primary key,language_name varchar(20));

create table gender(id int primary key,Gender varchar(10));



create table book_details(book_id int primary key,name varchar(50) ,booktype_id int,author_name varchar(20),publication varchar(50),language_id int,cost bigint,isavailable boolean,total_copies int,shelf_name varchar(10),foreign key(booktype_id) references category(id),foreign key(language_id) references langauage(id));

create table user_details(id int primary key auto_increment,rollno varchar(20),mailid varchar(30) unique,name varchar(30),first_year year,final_year year,degree_name varchar(10),branch varchar(20),dob date,genderid int,foreign key(genderid) references gender(id));

create table userandbook (id int auto_increment primary key,user_id int,book_id int,isbooklost boolean,dues int,issue_date date,return_date date,renew_date date,UNIQUE KEY (user_id, book_id),foreign key(user_id) references user_details(id),foreign key(book_id) references book_details(book_id));

create table librarian(id int primary key auto_increment,emailid varchar(20) unique,phoneno varchar(15),username varchar(20),loginpassword varchar(10),name varchar(20),qualification varchar(20),joining_date date,ending_date date,dob date,genderid int,foreign key(genderid) references gender(id));



use SGGSLibrary;
create table category(id int primary key ,category varchar(50) not null);
create table langauage(id int primary key,language_name varchar(20) not null);
create table gender(id int primary key,Gender varchar(10) not null);
create table book_details(id int primary key,name varchar(50) not null ,booktype_id int not null,author_name varchar(20) not null,publication varchar(50)not null,language_id int not null,cost bigint not null,isavailable boolean not null,total_copies int not null,shelf_name varchar(10) not null,foreign key(booktype_id) references category(id),foreign key(language_id) references langauage(id));
create table branch( id int primary key,branch_name varchar(20)not null);
create table user_details(id int primary key auto_increment,rollno varchar(20) unique not null,mailid varchar(30) unique not null,name varchar(30) not null,first_year year not null,final_year year not null,branch_id int not null,genderid int,foreign key(genderid) references gender(id),foreign key(branch_id) references branch(id));
create table userandbook (id int auto_increment primary key,user_id int not null,book_id int not null,isbooklost boolean not null,dues int not null,issue_date date not null,return_date date not null,renew_date date,UNIQUE KEY (user_id, book_id),foreign key(user_id) references user_details(id),foreign key(book_id) references book_details(id));

create table librarian(id int primary key auto_increment,emailid varchar(20) unique,phoneno varchar(15) not null,username varchar(20) unique not null,loginpassword varchar(10) unique not null,name varchar(20) not null,qualification varchar(20) not null,joining_date date not null,ending_date date not null,dob date not null,genderid int not null,foreign key(genderid) references gender(id));


insert into category values(1,"Fiction"),(2,"Horror"),(3,"Science Fiction"),(4,"Crime"),(5,"Education"),(6,"Sports");
insert into langauage values (11,"English"),(22,"Hindi"),(33,"Marathi"),(44,"Sanskrit");

insert into gender values(31,"Female"),(32,"Male"),(33,"Other");
insert into branch values (1,"CS"),(2,"IT"),(3,"EE"),(4,"ENTC"),(5,"ME");

insert into book_details values (1,"Age of Vice",1,"Deepti Kapoor","Riverhead Books",11,500,true,10,'A1'),
                         (2,"City Under One Roof",1,"Iris Yamashita","Berkley",11,700,true,20,'A1'),
                         (3,"The World and All That It Holds ",1,"Aleksandar Hemon","MCD",11,500,true,5,'A1'),
                         (4,"Maame ",1,"Jessica George","St. Martin's Press",11,560,true,8,'A1'),
                         (5,"Essex Dogs",1," Dan Jones","Viking",11,300,true,6,'A1'),
                         (6,"Homecoming",1,"Kate Morton","Mariner Books",11,300,true,11,'A1');
                         
                        
    insert into user_details values (1,"2019bel021","monika.sggs@gmail.com","Monika",'2019','2023',3,31),
                                     (2,"2019cs021","pranay.sggs@gmail.com","Pranay",'2019','2023',1,32),
                                     (3,"2019me021","rohan.sggs@gmail.com","Rohan",'2019','2023',5,32),
                                     (4,"2019bel022","hrutuja.sggs@gmail.com","Hrutuja",'2019','2023',3,31),
                                     (5,"2019it021","vaishnavi.sggs@gmail.com","Vaishnavi",'2019','2023',2,31);
                                                                       
       insert into userandbook values 
       (2,1,5,false,0,'2020-07-23','2020-08-01',null),
       (3,2,4,false,200,'2021-08-24','2021-08-06',null),
       (4,1,3,false,500,'2021-04-20','2020-05-01',null),
       (5,3,4,false,0,'2021-07-23','2021-08-23','2021-08-01');          
       
      alter table librarian drop column username;
      insert into librarian values (1,"mohanshah@gmail.com",'9087646588','first','Mohan Bhagwat','B.sc','2020-08-01','2022-08-01','1996-09-09',32),
                                    (2,"aman@gmail.com",'9087696588','second','Aman Agarwal','M.sc','2021-08-01','2023-02-01','1995-08-08',32),
                                    (3,"aryashinde@gmail.com",'9083446588','third','Arya Shinde','B.com','2020-03-01','2022-08-01','2000-02-19',31),
                                    (4,"adwait@gmail.com",'9087646188','fourth','Adwait Kapoor','M.sc','2020-04-01','2022-08-01','1993-09-09',32),
                                    (5,"aditishah@gmail.com",'9987646588','fifth','Aditi Shah','B.sc','2020-01-01','2022-08-01','1994-10-09',31),
                                    (6,"aishwarya@gmail.com",'9032646588','sixth','Aishwarya','M.sc','2021-07-23','2023-02-01','2000-07-23',31);
                                    
                                   
                                   
      show tables;
      select * from user_details;
      alter table user_details add unique(rollno);
      
     alter table librarian drop column ending_date;
      alter table librarian drop column dob;