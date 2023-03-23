insert into client(firstname, lastname, patronymic, date_of_birth, email, phone_number, created_at, updated_at, frozen,
                   is_delete, is_verify)
values ('igor', 'sobol', 'evg', '22.03.1908', 'gocha@lalalal.ru', '8002353535', '20.03.2000', '20.03.2000', false,
        false, false);

insert into currency(name)
values ('rub');

insert into account(name, frozen, comment, value, created_at, updated_at, client_id, currency_id)
values ('first', false, 'lalalal', 20, '20.03.2000', '20.03.2000', 1, 1);