CREATE TABLE user_lamp_corner
(
    id            BIGSERIAL PRIMARY KEY,
    cook_token             VARCHAR(150),
    name       VARCHAR(30),
    surname    VARCHAR(50),
    email      VARCHAR(100),
    hash   VARCHAR(100),
    email_confirmed   bool DEFAULT false
);

CREATE TABLE confirm_users
(
    id            BIGSERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES user_lamp_corner (id),
    token   VARCHAR(150),
    data_registration VARCHAR(100)
);

CREATE TABLE cookie_token
(
    user_id           INTEGER REFERENCES user_lamp_corner (id),
    cook_token             VARCHAR(150)
);