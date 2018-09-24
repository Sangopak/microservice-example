insert into users values ('user','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);
insert into users values ('admin','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);

insert into authorities values ('user','ROLE_USER');
insert into authorities values ('admin','ROLE_USER');
insert into authorities values ('admin','ROLE_ADMIN');

--commented below section as we have hooked up post to 
--insert into t_user values (1,{ts '1985-08-05 12:00:00'},'Sango',12345);
--insert into t_user values (2,{ts '1982-10-08 12:00:00'},'Pupu',12346);
--insert into t_user values (3,{ts '2016-08-05 12:00:00'},'Nellie',12346);