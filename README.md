# WalletProject CRUD приложение с использованием Spring DATA
в этой ветке сделан минимальный крад для сущностей Client и Account
http://localhost:8083/client/main/{id}/information достает основную информацию клиента без статусов и роли
http://localhost:8083/client/main/{id}/transactions достает все транзакции клиента 
http://localhost:8083/client/main/{id}/accounts достает все счета клиента
http://localhost:8083/client/main/{id}/create создает для клиента новый счет
для проверки функциала нужно использовать Postman

Скрипт для создания БД

create table if not exists document_format ( id integer generated always as identity primary key, document_format varchar unique ) ;

create table if not exists country ( id integer generated always as identity primary key, name varchar(50) not null unique, phone_code varchar(50) not null, document_format integer not null references document_format ) ;

create table if not exists client ( id bigint generated always as identity primary key, firstname varchar(50) not null, lastname varchar(50) not null, patronymic varchar(50) not null, date_of_birth date not null, email varchar not null constraint client_pk unique, phone_number varchar(50) not null, created_at date not null, updated_at date, frozen boolean not null, is_delete boolean not null, is_verify boolean not null );

create table if not exists document ( client_id integer not null primary key references client on delete cascade, document_number varchar(50) not null constraint document_pk unique, issue_date date not null, created_at date not null, country_id integer not null references country ) ;

create table if not exists role ( id integer generated always as identity primary key, name varchar(50) not null );

create table if not exists client_role ( client_id bigint references client on delete cascade, role_id integer references role );

create table if not exists auth_info ( client_id bigint not null primary key references client on delete cascade, password varchar not null );

create table if not exists currency ( id integer generated always as identity primary key, name varchar(50) not null unique );

create table if not exists account ( id bigint generated always as identity primary key, name varchar(50) not null, frozen boolean not null, comment varchar(100) default ''::character varying not null, value bigint not null, created_at date not null, updated_at date, client_id bigint not null references client, currency_id integer not null references currency );

drop table if exists transaction_type cascade ;
create table transaction_type(
    id  int primary key generated always as identity,
    type varchar(50) not null unique,
    comment varchar(100) not null default ''
);

drop table if exists transaction cascade ;
create table transaction(
    id  bigint primary key generated always as identity,
    value bigint not null,
    message varchar(100) not null default '',
    start_date_time timestamp not null,
    finish_date_time timestamp,
    status boolean not null default false,
    type int not null references transaction_type(id)
);

create table transaction_account (id bigint primary key generated always as identity, sender boolean default false not null, account_id bigint not null references account, transaction_id bigint not null references transaction);
