insert into users values ('user','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);
insert into users values ('admin','$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e',true);

insert into authorities values ('user','ROLE_USER');
insert into authorities values ('admin','ROLE_USER');
insert into authorities values ('admin','ROLE_ADMIN');

insert into t_user values (100,{ts '1985-08-05 12:00:00'},'Sango',12345);
insert into t_user values (101,{ts '1982-10-08 12:00:00'},'Pupu',12346);
insert into t_user values (102,{ts '2016-08-05 12:00:00'},'Nellie',12346);

insert into t_post values (1001,'100 Post1',100);
insert into t_post values (1002,'100 Post2',100);
insert into t_post values (1003,'100 Post3',100);
insert into t_post values (1004,'101 Post1',101);
insert into t_post values (1005,'101 Post2',101);
insert into t_post values (1006,'101 Post3',101);
insert into t_post values (1007,'102 Post1',102);
insert into t_post values (1008,'102 Post2',102);
insert into t_post values (1009,'102 Post3',102);