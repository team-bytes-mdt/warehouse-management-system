CREATE TYPE ORDER_STATUS AS ENUM ('PENDING', 'PROCESSING', 'COMPLETED', 'CANCELLED');

CREATE TABLE INVENTORY(
                          INVENTORY_ID BIGSERIAL PRIMARY KEY,
                          LOCATION VARCHAR(255) NOT NULL,
                          LAST_UPDATED_DATE DATE NOT NULL
);

CREATE TABLE ITEM(
                     ITEM_ID BIGSERIAL PRIMARY KEY,
                     NAME VARCHAR(255) NOT NULL,
                     DESCRIPTION TEXT,
                     QUANTITY INT NOT NULL,
                     PRICE DECIMAL(10, 2) NOT NULL,
                     CATEGORY VARCHAR(100) NOT NULL
);

CREATE TABLE USERS (
                       USER_ID BIGSERIAL PRIMARY KEY,
                       NAME VARCHAR(255) NOT NULL,
                       ADDRESS VARCHAR(255) NOT NULL,
                       ROLE VARCHAR(50) NOT NULL,
                       PHONE_NUMBER VARCHAR(15)
);



CREATE TABLE ORDERS (
                         ORDER_ID BIGSERIAL PRIMARY KEY,
                         CUSTOMER_ID BIGINT NOT NULL REFERENCES USERS(USER_ID),
                         STATUS ORDER_STATUS NOT NULL,
                         CREATED_DATE TIMESTAMP NOT NULL
);

CREATE TABLE ORDER_ITEM (
                            ORDER_ID BIGINT NOT NULL REFERENCES "ORDERS"(ORDER_ID) ON DELETE CASCADE,
                            ITEM_ID BIGINT NOT NULL REFERENCES ITEM(ITEM_ID) ON DELETE CASCADE,
                            QUANTITY INT NOT NULL CHECK (QUANTITY > 0),
                            PRIMARY KEY (ORDER_ID, ITEM_ID)
);

