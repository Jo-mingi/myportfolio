create table first_board(
	bid int not null auto_increment,
	subject varchar(100) not null,
	contents varchar(3000) not null,
	hit int,
	writer varchar(30) not null,
	regDate datetime default now() not null,
	primary key(bid)
);

insert into first_board(subject, contents, hit, writer) values('테스트 ~~~~', '테스트', 0, '운영자');

select * from first_board;
