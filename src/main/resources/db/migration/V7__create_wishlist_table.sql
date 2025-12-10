CREATE TABLE wishlist (
                          user_id    INT     NOT NULL,
                          product_id BIGINT  NOT NULL,

                          CONSTRAINT wishlist_pk
                              PRIMARY KEY (user_id, product_id),

                          CONSTRAINT wishlist_user_id_fk
                              FOREIGN KEY (user_id)
                                  REFERENCES users(id),

                          CONSTRAINT wishlist_product_id_fk
                              FOREIGN KEY (product_id)
                                  REFERENCES products(id)
);
