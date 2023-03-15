# auto-service-app

## Project description

An REST web-application, which accepts HTTP-requests, stores data in DB(PostgreSQL) and processes them.
Also, it uses Swagger API. Project was build according to SOLID principles.
It uses JSON format for request and response.

## Requests
#### MasterController:
+ POST - create Master
+ PUT - update Master
+ GET - get Master's orders
+ GET - calculate and get Master's salary

#### CarController:
+ POST - create Car
+ PUT - update Car

#### CarOwnerController:
+ POST - create CarOwner
+ PUT - update CarOwner
+ GET - get all completed or paid orders

#### OrderController:
+ POST - create Order
+ POST - add Goods to Order
+ PUT - update Order
+ PUT - update OrderStatus
+ GET - calculate and get final price

#### FavorController:
+ POST - create Favor
+ PUT - update Favor
+ PUT - update FavorStatus

#### GoodsController:
+ POST - create Goods
+ PUT - update Goods

## Notes
+ A person's discount on goods = the number of his orders * 1%
+ A person's discount on favors = the number of his orders * 2%
+ Master's salary = 40% of the cost of the service he was engaged in
+ When calculating and issuing the master's salary, the status of the service changes to
  "paid"
+ When changing the status of the order to "successfully completed" or "unsuccessful
  completed", the completion date is equal to the current date

## Project structure
Project was built according to 3-tier architecture - the presentation tier; the application tier, where data is processed; and the data tier, where the data associated with the application is stored and managed:
- Controllers - Presentation tier
- Services - Application tier
- Repositories - Data tier

## 💻 Technologies:

- JAVA 17 or higher
- Maven 3
- SpringBoot v.2.5.6
- PostgreSQL v.14.1-alpine
- Swagger API v.3.0.0
- Hibernate
- Docker

## Installation

- Clone this project from GitHub;
- Install [Docker](https://docs.docker.com/engine/install/);
- Execute docker-compose up in terminal;
- Open http://localhost:8082/swagger-ui/# in browser
