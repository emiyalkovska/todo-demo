# TODO demo application

TODO demo application in SpringBoot

## Running service

First we need to set up PostgreSQL DB.

```
docker run --name todo-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_USERNAME=postgres -p 5432:5432 --restart always -d postgres
```