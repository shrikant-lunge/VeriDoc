
create database veri_doc;
use veri_doc;

create table admin
(
	admin_id int auto_increment primary key,
    admin_name varchar(60) unique not null,
    admin_pass varchar(60) not null
);

create table document
(
	id bigint auto_increment primary key,
    file_name varchar(60) not null,
    verification_code varchar(60) unique not null,
    hash_code varchar(60) not null,
    status enum("VALID","INVALID") default "VALID",
    uploaded_at timestamp default current_timestamp
);

create table verification_log
(
	log_id bigint auto_increment primary key,
    verification_code varchar(60) ,
    verification_at timestamp default current_timestamp,
    result enum("AUTHENTIC", "TAMPERED", "NOT FOUND"),
    constraint fk_verification_code foreign key(verification_code) references document(verification_code) on delete cascade
);

select * from document;