create table users
(
    id         serial
        constraint user_pk
            primary key,
    first_name varchar(100) not null,
    last_name  varchar(100),
    username   varchar(100) not null,
    password   varchar(256) not null
);