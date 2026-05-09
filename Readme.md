## Запуск через Docker

### 1. Создать `.env` файл

В корне проекта создайте файл `.env` с конфигурацией postgres. Например:

```env
POSTGRES_USER=admin_h2o
POSTGRES_PASSWORD=admin_h2o
POSTGRES_DB=h2o
```

---

### 2. Запуск

```bash
docker compose up --build
```

---

## Сервисы

После запуска доступны:

* Backend: [http://localhost:8080](http://localhost:8080)
* Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* PostgreSQL: 127.0.0.1:5432

---

## Примечания

* База данных создаётся автоматически через Liquibase
* При первом запуске используется миграция схемы
* Все конфигурации берутся из переменных окружения
