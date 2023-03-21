CREATE TABLE USER_
(
    id     INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    login    VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE USER_ORDER
(
    id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id     INTEGER NOT NULL,
    total_price VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES USER_ (id)
);

CREATE TABLE GOOD
(
    id    INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    price DOUBLE
);

CREATE TABLE ORDER_GOOD
(
    id       INTEGER NOT NULL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    good_id  INTEGER NOT NULL,
    FOREIGN KEY (order_id) REFERENCES USER_ORDER (id),
    FOREIGN KEY (good_id) REFERENCES GOOD (id)
);