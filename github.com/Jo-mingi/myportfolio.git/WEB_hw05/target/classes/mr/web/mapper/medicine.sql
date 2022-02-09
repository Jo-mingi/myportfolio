create table medicine(
	num int primary key auto_increment,
	entpName varchar(100) not null,
	itemName varchar(200) not null,
	itemSeq int not null,
	efcyQesitm varchar(500),
	useMethodQesitm varchar(1000),
	atpnWarnQesitm varchar(1000),
	atpnQesitm varchar(1500),
	intrcQesitm varchar(1000),
	seQesitm varchar(1000),
	depositMethodQesitm varchar(200),
	openDe varchar(50),
	updateDe int,
	itemImage varchar(200)
);

select * from medicine;

drop table medicine;


