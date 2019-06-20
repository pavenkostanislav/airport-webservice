# airport-webservice

RESTFul WEB-сервис регистрации, перерегистрации и удаления рейсов, предоставления информации по аэропортам и всем зарегистрированным рейсам.

##Используемые технологии: 
- Java 8
- Spring core/Boot, JPA
- H2
- Flyway

## Features
- Сервис полосы
- Сервис аэропорта
- Сервис расписания

###Сервис полосы
>- Имя класса: 
> - Lane
>- Поля класса:
> - ID (числовой) – уникальный генерируемый ключ
> - Обозначение полосы (строковый) – не может быть пустым
> - Код аэропорта (числовой) – не может быть пустым

Примеры в формате json

```
POST /api/lane HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"strip":"ВПП-2","airportId":1}
```

```
GET /api/lane/1 HTTP/1.1
Host: localhost:8080
content-type: application/json
Cache-Control: no-cache
```

```
PUT /api/lane/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"id":1,"strip":"test","airportId":1}
```

```
DELETE /api/lane/3 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```

Request

```
POST /api/lane/all HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```

Response

```
[
    {
        "strip": "ВПП-1",
        "airportId": 1,
        "airport": null,
        "id": 1
    },
    {
        "strip": "ВПП-3",
        "airportId": 1,
        "airport": null,
        "id": 3
    }
]
```

Примеры в формате xml

Request

```
POST /api/lane/all?format=xml HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
```

Response

```
<ArrayList>
    <item>
        <strip>ВПП-1</strip>
        <airportId>1</airportId>
        <airport/>
        <id>1</id>
    </item>
    <item>
        <strip>ВПП-3</strip>
        <airportId>1</airportId>
        <airport/>
        <id>3</id>
    </item>
</ArrayList>
```

###Сервис Аэропорта
>- Имя класса:
> - Airport
>- Поля класса:
> - ID (числовой) – уникальный генерируемый ключ
> - Город (строковый) – не может быть пустым
> - IATA-код (строковый) – уникальный, не может быть пустым
> - Количество полос
> - Расписание

###Сервис расписания
>- Имя класса:
> - Schedule
>- Поля класса:
> - ID (числовой) – уникальный генерируемый ключ
> - Дата-время прибытия (Дата-время) – время в UTC
> - Код полосы прибытия (числовой) – не может быть пустым
> - Дата-время вылета (Дата-время) – время в UTC
> - Код полосы вылета (числовой) – не может быть пустым
> - Рейс
>- Ограничения:
> - Время регистрации вылета и прилета указывается с точностью до часа
> - Количество прилетев и вылетов не должно превышать количества полос в аэропорту.
 
Примеры в формате json

Request

```
POST /api/schedule HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache

{"flight":"ЮТ 351", "arrival": "2019-06-20T12:33:33", "departure": "2019-06-20T18:22:22", "laneId": 1, "airportId":1 }
```
