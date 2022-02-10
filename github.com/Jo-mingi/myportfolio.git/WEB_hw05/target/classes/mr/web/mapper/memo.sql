create table memo(
	mnum int primary key auto_increment,
	id varchar(20) not null,
	itemName varchar(200) not null,
	memo varchar(2000) not null
);

select * from memo;

drop table memo;
