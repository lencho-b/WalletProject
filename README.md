# WalletProject CRUD приложение с использованием Spring DATA
в этой ветке сделан минимальный крад для сущностей Client и Account
http://localhost:8083/client/main/{id}/information достает основную информацию клиента без статусов и роли
http://localhost:8083/client/main/{id}/transactions достает все транзакции клиента 
http://localhost:8083/client/main/{id}/accounts достает все счета клиента
http://localhost:8083/client/main/{id}/create создает для клиента новый счет
для проверки функциала нужно использовать Postman

Скрипт для создания БД

create table client_role
  (
  id_client bigint  not null,
  id_role   integer not null
  );

create table currency
   (
    id serial
    primary key,
    index integer,
    name  varchar(50) not null
    );

create table document_format
    (    
    id integer not null
    primary key,
    document_format text
    );

create table country
(
    id integer     not null
    primary key,
    name varchar(50) not null,
    phone_code varchar(50) not null,
    document_format integer     not null
    constraint fkrqe18yi65luqwbypod506y3bi
    references document_format
);

create table document
(
    id bigint not null
    primary key,
    created_at date not null,
    document_number varchar(50) not null,
    issue_date date not null,
    updated_at date  not null,
    country_id  integer not null
    constraint fkchu8sfgaej2j8g29e6aywhtqg
    references country
);

create table client
(
    id bigserial
    primary key,
    created_at date  not null,
    date_of_birth date not null,
    email text not null,
    firstname varchar(50) not null,
    frozen boolean  not null,
    is_delete boolean not null,
    is_verify  boolean  not null,
    lastname varchar(50) not null,
    patronymic varchar(50) not null,
    phone_number varchar(50) not null,
    updated_at date  not null,
    document_id   bigint
        constraint fkbxhupy156s101isegs5aculms
            references document
);

create table account
(
    id          bigserial
        primary key,
    comment     varchar(100) not null,
    created_at  date         not null,
    frozen      boolean      not null,
    name        varchar(50)  not null,
    updated_at  date         not null,
    value       bigint       not null,
    client_id   bigint       not null
        constraint fkkm8yb63h4ownvnlrbwnadntyn
            references client,
    currency_id integer      not null
        constraint fk316pn109iutn6yqoxrqp09cpc
            references currency
);

create table auth_info
(
    client_id bigint      not null
        primary key
        constraint fk92t9v6gkbjmyym46m9fpst0si
            references client
            on delete cascade,
    login     varchar(50) not null,
    password  text        not null
);

create table role
(
    id        integer     not null
        primary key,
    role_name varchar(50) not null
);

create table transaction_type
(
    id      integer      not null
        primary key,
    comment varchar(100) not null,
    type    varchar(50)  not null
);

create table transaction
(
    id               bigint                      not null
        primary key,
    finish_date_time timestamp(6) with time zone,
    message          varchar(100)                not null,
    start_date_time  timestamp(6) with time zone not null,
    status           boolean                     not null,
    value            bigint                      not null,
    type             integer                     not null
        constraint fk5sn54tdtl540nn1qwfvt7nhd5
            references transaction_type
);

create table transaction_account
(
    sender         boolean default false not null,
    account_id     bigint                not null
        references account,
    transaction_id bigint                not null
        references transaction
);
