create table medicine_member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pw varchar(20) not null,
	name varchar(20) not null,
	age int not null,
	email varchar(50) not null,
	tel varchar(30) not null,
	unique key(id)
);

select * from medicine_member;