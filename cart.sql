create table product
(
  id    int          null,
  name  varchar(255) null,
  price float        null
);

insert into product values (1, '黑色的丝袜', 500);
insert into product values (2, '充气娃娃', 2500);
insert into product values (3, '皮鞭', 180);
insert into product values (4, '蜡烛', 0.20);


create table user
(
  id       int         null,
  name     varchar(10) null,
  password varchar(50) null
);

insert into user values (1, 'admin', 'root');


create table order_ (
  id  int AUTO_INCREMENT,
  uid int,
  primary key (id)
);

create table orderitem (
  id  int AUTO_INCREMENT,
  pid int,
  num int,
  oid int,
  primary key (id)
);
