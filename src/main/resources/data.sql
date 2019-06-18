INSERT INTO AIRPORT (city, iata_code, lane_count, schedule_id) VALUES ('Нижний Новгород', 'GOJ' , 0, null);
SELECT @ID := SCOPE_IDENTITY();
INSERT INTO LANE (strip, airport_id) VALUES ('ВПП-1', @ID);
INSERT INTO LANE (strip, airport_id) VALUES ('ВПП-2', @ID);
UPDATE AIRPORT SET lane_count = 2 WHERE id = @ID;