INSERT INTO AIRPORT (city, iata_code, lane_count) VALUES ('Нижний Новгород', 'GOJ' , 0);
SELECT @AIRPORTID := SCOPE_IDENTITY();
INSERT INTO LANE (strip, airport_id) VALUES ('ВПП-1', @AIRPORTID);
SELECT @LANEID1 := SCOPE_IDENTITY();
/*INSERT INTO LANE (strip, airport_id) VALUES ('ВПП-2', @AIRPORTID);
SELECT @LANEID2 := SCOPE_IDENTITY();*/
UPDATE AIRPORT SET lane_count = 2 WHERE id = @AIRPORTID;
INSERT INTO SCHEDULE (flight, arrival, departure, lane_id, airport_id) VALUES ('ЮТ 351', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), @LANEID1, @AIRPORTID);