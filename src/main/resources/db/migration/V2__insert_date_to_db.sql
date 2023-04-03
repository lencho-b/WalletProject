insert into client(firstname, lastname, patronymic, date_of_birth, email, phone_number, created_at, updated_at, frozen,
                   is_delete, is_verify)
values ('igor', 'sobol', 'evg', '22.03.1908', 'gocha@lalalal.ru', '8002353535', '20.03.2000', '20.03.2000', false,
        false, false),
       ('lena', 'domroch', 'evg', '22.03.1999', 'domroch@gmail.com', '8002353535', '20.03.2000', '20.03.2000', false,
        false, false);

insert into currency(name)
values ('rub');

insert into account(name, frozen, comment, value, created_at, updated_at, client_id, currency_id)
values ('first', false, 'test1', 10000, '20.03.2000', '20.03.2000', 1, 1),
       ('second', false, 'test2', 10000, '20.01.2000', '20.01.2000', 1, 1),
       ('third', false, 'test3', 10000, '20.01.2000', '20.01.2000', 1, 1);

insert into transaction_type(type, comment) values ('перевод', 'отправление денег с активного счета'),
                                                   ('получение', 'получение денег на активный счет'),
                                                   ('оплата','проведение платежа с активного счета');

insert into transaction(value, message, start_date_time, finish_date_time, status, type_id)
VALUES (100, 'перевод тест1 ', now(), null, false, 1);


insert into transaction_account(sender, account_id, transaction_id)
values (true, 1, 1),
       (false, 2, 1);

insert into role(name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into auth_info(client_id, password)
values (2, '$2a$10$1Rht.o4HUTVxc10QrzT4Xe1qbvcP/ToE3Z8GtlQ71vMRFkDRTBDae'),
       (1, '$2a$10$g.k4W9h.oHRK7K8nI0Z7mON/N5OcYp4qog0GNDF1BJa21/UNssxK.');

insert into client_role(client_id, role_id)
values (1, 1),
       (2, 2);