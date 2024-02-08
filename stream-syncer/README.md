# Stream Syncer

Welcome to **stream-syncer**! This project is built using the Spring Boot framework implementing the hexagonal architecture pattern.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)

## Getting Started

These instructions will help you set up the project on your local machine.

## Prerequisites

Before you begin, make sure you have the following installed:

- Java SE Development Kit 17.x.x


### Installation

1. Clone the repository:

```
git clone git@bitbucket.org:IWinnovacion/stream-syncer.git
cd stream-syncer
```

2. Build the project using Gradle:

```
./build.sh
```

2. Deploy the application:

```
./deploy.sh
```

## Configuration
In order to start the application, some environment variables must be configured as in the example shown below:

```
ELASTICSEARCH_CLIENT_ENDPOINT=elasticsearch:9200
ELASTICSEARCH_CLIENT_PASSWORD=elk_passwod
ELASTICSEARCH_CLIENT_USERNAME=poc_invex
ELASTICSEARCH_REST_PASSWORD=elk_passwod
ELASTICSEARCH_REST_URIS=http://elasticsearch:9200
ELASTICSEARCH_REST_USERNAME=elk_user
KAFKA_BROKER=localhost:9092
KAFKA_GROUP_ID=group_01
KAFKA_LOG_EVENTS_TOPIC=log_store
KAFKA_PASSWORD=kafka_password
KAFKA_USERNAME=kafka_user
```

## Usage
To start the application using the spring profile *local*, execute the following command:

```
./gradlew bootRun --args='-Dspring.profiles.active=local'
```

Your Spring Boot application should now be accessible on [http://localhost:8080/app](http://localhost:8080/app).

## API Documentation
The project uses *springdoc-openapi* to generate the API documentation. To access the **API docs**, go to [http://localhost:8080/app/api](http://localhost:8080/app/api).


{
    "id": "4139578224492750041L-1",
    "logTs": "2024-01-31T23:40:56.703",
    "system": "test",
    "hostName": "local",
    "source": "manual",
    "logMessage": "mensaje de prueba"
}

