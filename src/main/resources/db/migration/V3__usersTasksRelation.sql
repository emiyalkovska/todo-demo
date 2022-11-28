alter table task
    add column user_id bigint references users (id);

alter table task
drop
column created_by;

alter table task
drop
column assigned_to;