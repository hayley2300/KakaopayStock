DROP TABLE IF EXISTS tran;

CREATE TABLE tran (
tran_date varchar(8) not null,
acct_no varchar(8) not null,
tran_no integer not null,
amount bigint not null default 0,
fee bigint not null default 0,
cancel_flag varchar(1),
primary key(tran_date, tran_no));


DROP TABLE IF EXISTS account;
CREATE TABLE account (
acct_no varchar(8) not null,
acct_name varchar(8) not null,
branch_cd varchar(1) not null,
primary key(acct_no));


DROP TABLE IF EXISTS branch;
CREATE TABLE branch (
branch_cd varchar(1) not null,
branch_nm varchar(20) not null,
primary key(branch_cd));


