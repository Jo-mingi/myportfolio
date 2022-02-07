create table medicine(
	num int primary key auto_increment,
	entpName varchar(100) not null,
	itemName varchar(200) not null,
	itemSeq int not null,
	efcyQesitm varchar(500),
	useMethodQesitm varchar(200),
	atpnWarnQesitm varchar(500),
	atpnQesitm varchar(1000),
	intrcQesitm varchar(50),
	seQesitm varchar(500),
	depositMethodQesitm varchar(200),
	openDe varchar(50),
	updateDe int,
	itemImage varchar(200),
	unique key(itemName, itemSeq)
);

select * from medicine;


