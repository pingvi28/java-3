CREATE TABLE employee
(
    Id SERIAL PRIMARY KEY,
    NAME varchar(100) not null,
    SURNAME varchar(100) not null,
    PATRONYMIC varchar(100) not null,
    PHONE_NUMBER varchar(20) not null,
    EMAIL  varchar(255)
);