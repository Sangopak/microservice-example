insert into users values ('user','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);
insert into users values ('admin','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);

insert into authorities values ('user','ROLE_USER');
insert into authorities values ('admin','ROLE_USER');
insert into authorities values ('admin','ROLE_ADMIN');