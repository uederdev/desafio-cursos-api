create table if not exists cursos(
                                     id UUID not null primary key,
                                     name varchar(80) not null,
                                     category varchar(80) not null,
                                     teacher varchar(80) not null,
                                     active boolean not null,
                                     created_at timestamp default now(),
                                     updated_at timestamp default now()
);