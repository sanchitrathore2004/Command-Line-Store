create table profiles
(
    id             int           not null
        primary key,
    bio            varchar(255)  null,
    phone_number   varchar(255)  null,
    date_of_birth  date          null,
    loyalty_points int default 0 null,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);

