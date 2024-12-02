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

CREATE TABLE USERS(
                     USER_ID BIGSERIAL PRIMARY KEY,
                     NAME VARCHAR(255) NOT NULL,
                     ADDRESS VARCHAR(255) NOT NULL,
                     ROLE VARCHAR(50) NOT NULL
);