create table product
(
  id    int          null,
  name  varchar(255) null,
  price float        null
);

create table user
(
  id       int         null,
  name     varchar(10) null,
  password varchar(50) null
);

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
