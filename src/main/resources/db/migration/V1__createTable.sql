create table task
(

    id          serial
        constraint task_pk
            primary key,
    name        varchar(100) not null,
    dueDateTime timestamp,
    description varchar(250),
    createdBy   varchar(100),
    assignedTo  varchar(100),
    completed   bool

);
