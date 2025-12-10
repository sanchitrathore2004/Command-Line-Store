alter table wishlist
drop foreign key wishlist_product_id_fk;

alter table wishlist
    add constraint wishlist_product_id_fk
        foreign key (product_id) references products (id)
            on delete cascade;

alter table wishlist
drop foreign key wishlist_user_id_fk;

alter table wishlist
    add constraint wishlist_user_id_fk
        foreign key (user_id) references users (id)
            on delete cascade;

