/*insert into client(firstname, lastname, patronymic, date_of_birth, email, phone_number, created_at, updated_at, frozen,
                   is_delete, is_verify)
values ('Игорь', 'Солод', 'Дмитрьевич',  cast('1990/05/28' as date), 'igorSovol@1990.ru', '8802552225', cast('2015/05/16' as date), cast('2015/05/16' as date), false,
    false, false),
 ('Татьяна', 'Заречка', 'Ивановна',  cast('1989/01/01' as date), 'tanuySovet@98.ru', '8802511100', cast('2020/01/10' as date), cast('2021/05/16' as date), false,
        false, true),
 ('Михаил', 'Цверг', 'Степанович',  cast('1984/05/28' as date), 'mishaCherg@2001.ru', '88002220033', cast('2021/01/10' as date), cast('2021/01/10' as date), false,
        false, true),
 ('Светлана', 'Одуван', 'Васильевна',  cast('1952/11/28' as date), 'odyvanSvets@52.ru', '8802552200', cast('2022/05/16' as date), cast('2022/05/16' as date), false,
        false, true),
 ('Дмитрий', 'Медведев', 'Дмитрьевич',  cast('1979/05/04' as date), ' BearDmitrya@79.ru', '8802552211', cast('2023/01/10' as date), cast('2023/01/10' as date), false,
        false, false);*/

/*
insert into currency(name)
values ('RUB'),
       ('USD'),
       ('AUD'),
       ('EUR');*/

/*
insert into account(name, frozen, comment, value, created_at, updated_at, client_id, currency_id)
values ('main', false, 'нет', 10000, cast('2022/01/28' as date), cast('2022/01/28' as date), 1,1),
       ('foreign', false, 'основной', 12000, cast('2022/02/07' as date) ,cast('2022/02/07' as date), 1, 3),
       ('main', true, 'основной', 100000, cast('2022/01/09' as date), cast('2022/01/09' as date), 5, 1),
       ('foreign', false, 'нет', 100, cast('2022/11/28' as date), cast('2022/11/28' as date), 5, 2),
       ('foreign', false, 'основной', 29, cast('2023/01/28' as date),cast('2023/01/28' as date), 5, 4);
*/

-- insert into transaction_type(type, comment) values ('перевод', 'отправление денег с активного счета'),
--                                                    ('получение', 'получение денег на активный счет'),
--                                                    ('оплата','проведение платежа с активного счета');

/*insert into transaction(value, message, start_date_time, finish_date_time, status, type_id)
VALUES (100, 'перевод Дарье Кейнг', now(), null, true, 1),
       (100, 'покупка магнит ', now(), null, false, 2),
       (100, 'от Томилина Р.О ', now(), null, false, 3),
       (100, 'покупка овощной ', now(), null, true, 3),
       (100, 'опалата билайн ', now(), null, false, 3);*/

/*
insert into transaction_account(sender, account_id, transaction_id)
values (true, 1, 1),
       (true, 5, 2),
       (true, 5, 1),
       (false, 5, 2);*/

--
-- insert into role(name)
-- values ('user'),
--        ('admin');

/*insert into document_format(document_format)
values ('txt'),
       ('pdf');*/

/*insert into country(name, phone_code, document_format)
values ('Россия', '+7', 1),
       ('Украина', '+380', 1),
       ('Китай', '+86', 2),
       ('США', '+1', 2),
       ('Беларусия', '+345', 1);*/
/*insert into document(client_id,document_number, issue_date, created_at, country_id)
values (1,'0001-001', cast('2023/04/01' as date), cast('2023/04/01' as date), 1),
       (2,'0001-002', cast('2023/04/01' as date), cast('2023/04/01' as date), 5),
       (3,'0001-003', cast('2023/04/01' as date), cast('2023/04/01' as date), 1),
       (4,'0001-004', cast('2023/04/01' as date), cast('2023/04/01' as date), 3),
       (5,'0001-005', cast('2022/01/09' as date), cast('2022/01/09' as date), 2);
*/