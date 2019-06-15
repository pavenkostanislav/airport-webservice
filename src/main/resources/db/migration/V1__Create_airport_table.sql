create table Airport (
    ID int not null primary key,
    City varchar(100) not null,
    IATA varchar(100) not null,
    Strips int,
    Schedule int
);