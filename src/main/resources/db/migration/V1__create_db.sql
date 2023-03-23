
drop table if exists document_format cascade ;
create table document_format (
    id int primary key generated always as identity,
    document_format varchar unique
);

drop table if exists country cascade ;
create table country (
    id int primary key generated always as identity,
    name varchar(50) not null unique,
    phone_code varchar(50) not null,
    document_format int references document_format(id) not null
);


drop table if exists client cascade;
create table client(
    id bigint primary key generated always as identity,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    patronymic varchar(50) not null,
    date_of_birth date not null,
    email varchar not null,
    phone_number varchar(50) not null,
    created_at date not null,
    updated_at date not null,
    frozen boolean not null,
    is_delete boolean not null,
    is_verify boolean not null
);

drop table if exists document cascade ;
create table document(
    id bigint primary key references client(id) on delete cascade,
    document_number varchar(50) not null,
    issue_date date not null,
    created_at date not null,
    updated_at date not null,
    country_id int not null references country (id)
);

drop table if exists role cascade ;
create table role(
    id int primary key generated always as identity,
    role_name varchar(50) not null
);

drop table if exists client_role cascade ;
create table client_role(
    id_client bigint references client (id),
    id_role int references role(id)
);

drop table if exists auth_info cascade ;
create table auth_info(
    id bigint primary key references client (id) on delete cascade,
    login varchar(50) not null unique,
    password varchar not null
);

drop table if exists currency cascade ;
create table currency(
    id int primary key generated always as identity,
    name varchar(50) not null unique,
    index int
);

drop table if exists account cascade ;
create table account(
    id  bigint primary key generated always as identity,
    name varchar(50) not null,
    frozen boolean not null,
    comment varchar(100) default '' not null,
    value bigint not null,
    created_at date not null,
    updated_at date not null,
    client_id bigint not null references client(id),
    currency_id int not null references currency(id)
);

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

drop table if exists transaction_account cascade ;
create table transaction_account(
    id  bigint primary key generated always as identity,
    id_account bigint not null references account(id),
    id_transaction bigint not null references transaction(id),
    sender boolean not null default false
);