create table user_tags
(
    user_id int not null,
    tag_id  int not null,
    constraint user_tags_pk
        primary key (user_id, tag_id),
    constraint user_tags_user_fk
        foreign key (user_id) references users (id),
    constraint user_tags_tag_fk
        foreign key (tag_id) references tags (id)
);
