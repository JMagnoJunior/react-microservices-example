--INSERT INTO GUEST(ID,NAME,PASSPORT) VALUES(1,'John','111');
--INSERT INTO GUEST(ID,NAME,PASSPORT) VALUES(2,'Peter','222');
--INSERT INTO GUEST(ID,NAME,PASSPORT) VALUES(3,'Joseph','333');

INSERT INTO ADDRESS(id, zip_code, city, state, street_address) VALUES(1 ,'70680500', 'Brasilia', 'DF', 'LT 1, BL 1');
INSERT INTO LOCATION(id,LATITUDE, LONGITUDE) VALUES(1,1,1);
--INSERT INTO ACCOMMODATION_SCHEDULE(id) values(1);
INSERT INTO ACCOMMODATION(id, NAME, ID_LOCATION, ID_ADDRESS) VALUES(1, 'TRYP',1, 1 );

INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(1,'2018-04-01',false, 1, 100);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(2,'2018-04-02',true, 1, 100);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(3,'2018-04-03',true, 1, 100);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(4,'2018-04-04',true, 1, 100);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(5,'2018-04-05',true, 1, 100);


INSERT INTO ADDRESS(id, zip_code, city, state, street_address) VALUES(2 ,'70680600', 'Brasilia', 'DF', 'LT 2, BL 2');
INSERT INTO LOCATION(id,LATITUDE, LONGITUDE) VALUES(2,2,2);
--INSERT INTO ACCOMMODATION_SCHEDULE(id) values(2);
INSERT INTO ACCOMMODATION(id, NAME, ID_LOCATION, ID_ADDRESS) VALUES(2, 'PARIS',2, 2 );

INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(6,'2018-04-01',true, 2, 150);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(7,'2018-04-02',true, 2, 150);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(8,'2018-04-03',true, 2, 150);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(9,'2018-04-04',true, 2, 150);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(10,'2018-04-05',true, 2, 150);

INSERT INTO ADDRESS(id, zip_code, city, state, street_address) VALUES(3 ,'70680700', 'Brasilia', 'DF', 'LT 3, BL 3');
INSERT INTO LOCATION(id,LATITUDE, LONGITUDE) VALUES(3,3,3);
--INSERT INTO ACCOMMODATION_SCHEDULE(id) values(3);
INSERT INTO ACCOMMODATION(id, NAME, ID_LOCATION, ID_ADDRESS) VALUES(3, 'MELIA',3, 3 );

INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(11,'2018-04-01',true, 3, 200);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(12,'2018-04-02',true, 3, 200);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(13,'2018-04-03',true, 3, 200);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(14,'2018-04-04',true, 3, 200);
INSERT INTO DATE_AVAILABILITY(id,date,avaliable,  id_schedule, price) values(15,'2018-04-05',true, 3, 200);

commit;