# Clean Arch
Simple API to create and find users. Just to put in practice clean architecture.

## Technologies
- Kotlin
- Spring
- Docker
- Mongo

## Request Example

### Create User
```
curl --location --request POST 'http://localhost:8080/users/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Some Name"
}'
```

#### Response
```json
{
    "uuid": "1626ccf7-c280-4094-9798-861f82422dc8",
    "name": "Some Name"
}
```

### Find User
```
curl --location --request GET 'http://localhost:8080/users/1626ccf7-c280-4094-9798-861f82422dc8'
```

#### Response
```json
{
    "uuid": "1626ccf7-c280-4094-9798-861f82422dc8",
    "name": "Some Name"
}
```

## How to run

### Requirements:
- [Docker](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/)

## Running with Docker Compose
Runs both the application and Mongo
```
docker-compose up --build
```

## TODO
- Error handling
- Controller tests
- Integration tests
- CI
- Cache