create table task
(

    id            serial
        constraint task_pk
            primary key,
    name          varchar(100) not null,
    description   varchar(250),
    due_date_time timestamp,
    created_by    varchar(100),
    assigned_to   varchar(100),
    completed     bool

);
