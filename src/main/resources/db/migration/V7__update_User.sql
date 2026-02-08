
alter table users add column password varchar(255) not null default 123,
    add  column is_verified boolean default false,
    add  column is_active boolean default true,
    add column role varchar(50)  not null default 'User';