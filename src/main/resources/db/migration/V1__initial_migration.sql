create table users
(
    id       int auto_increment
        primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    constraint email
        unique (email)
);

create table address
(
    id      int auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    pincode varchar(255) not null,
    user_id int          not null,
    constraint address_ibfk_1
        foreign key (user_id) references users (id)
);

create index user_id
    on address (user_id);

