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