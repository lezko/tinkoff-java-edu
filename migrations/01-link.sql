create table link
(
    id bigint generated always as identity,
    url text not null,
    last_check_time timestamp with time zone not null,
    creation_time timestamp with time zone not null,

    primary key (id),
    unique (url)
)