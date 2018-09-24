create table users(
	username varchar(100) not null primary key,
	password varchar(100),
	enabled boolean not null
);

create table authorities(
	username varchar(100) not null,
	authority varchar(100) not null
);

alter table authorities add constraint fk_authorities_users foreign key (username) references users(username);
		
create unique index ix_auth_username on authorities(username,authority);


create sequence hibernate_sequence start with 1 increment by 1;
create table t_user (id integer not null, dob timestamp, name varchar(255), ssn bigint, primary key (id));