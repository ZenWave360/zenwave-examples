create table do_customer_request_outbox
(
    id           identity not null primary key,
    binding_name varchar(255) not null,
    payload      varchar(255) not null,
    headers      varchar(255) not null,
    created_at   timestamp    not null default current_timestamp,
    sent_at      timestamp
);

create table on_customer_event_outbox
(
    id           identity not null primary key,
    binding_name varchar(255) not null,
    payload      varchar(255) not null,
    headers      varchar(255) not null,
    created_at   timestamp    not null default current_timestamp,
    sent_at      timestamp
);
