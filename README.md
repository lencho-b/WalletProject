# WalletProject CRUD приложение с использованием Spring DATA
в этой ветке сделан минимальный крад для сущностей Client и Account
http://localhost:8083/client/main/{id}/information достает основную информацию клиента без статусов и роли
http://localhost:8083/client/main/{id}/transactions достает все транзакции клиента 
http://localhost:8083/client/main/{id}/accounts достает все счета клиента
http://localhost:8083/client/main/{id}/create создает для клиента новый счет
для проверки функциала нужно использовать Postman

## Технологии
- Java 17
- Maven
- Spring Boot 3.0.4
- Swagger
- FlyWay
- PostgreSql
- Docker

### Swagger
__http://localhost:8083/swagger-ui/index.html__

### Пользователи

| name              | password | roles       |
|-------------------|----------|-------------|
| igorSovol@1990.ru | user     | USER        |
| tanuySovet@98.ru  | admin    | ADMIN, USER |

