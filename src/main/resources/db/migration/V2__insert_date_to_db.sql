insert into client(firstname, lastname, patronymic, date_of_birth, email, phone_number, created_at, updated_at, frozen,
                   is_delete, is_verify)
values ('igor', 'sobol', 'evg', '22.03.1908', 'gocha@lalalal.ru', '8002353535', '20.03.2000', '20.03.2000', false,
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
values ('user'),
       ('admin');
