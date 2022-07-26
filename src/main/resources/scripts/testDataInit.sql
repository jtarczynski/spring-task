INSERT INTO CARS (ID, BRAND, CAR_TYPE, COLOR, ENGINE, MILLEAGE, PRODUCTION_YEAR)
VALUES (1, 'Mercedes', 'Suv', 'Black', '3.0', 10000, 2017),
       (2, 'Mercedes', 'Suv', 'White', '3.0', 230000, 2020),
       (3, 'BMW', 'Sedan', 'Red', '2.0', 200000, 2016),
       (4, 'Opel', 'Suv', 'Black', '1.4', 90000, 2015),
       (5, 'Mazda', 'Suv', 'Blue', '2.0', 86531, 2017);

INSERT INTO HUMANS (ID, NAME, HUMAN_TYPE)
VALUES (1, 'Human', 'WORKER'),
       (2, 'Human2', 'WORKER'),
       (3, 'Human3', 'WORKER'),
       (4, 'Human4', 'WORKER'),
       (5, 'Human5', 'CLIENT'),
       (6, 'Human6', 'CLIENT');


INSERT INTO WORKER_CAR (WORKER_ID, CAR_ID)
VALUES (1, 1),
       (1, 2),
       (2, 4),
       (3, 4);

INSERT INTO RENTS (ID, RENT_CAR)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1),
       (9, 1),
       (10, 1),
       (11, 2),
       (12, 2),
       (13, 2),
       (14, 2),
       (15, 2),
       (16, 2),
       (17, 2),
       (18, 2),
       (19, 2),
       (20, 2),
       (21, 2),
       (22, 3);

INSERT INTO FACILITIES (ID, PHONE_NUMBER)
VALUES ( 1, 921-231-212 ),
       ( 2, 312-231-212 ),
       ( 3, 752-111-212 ),
       ( 4, 900-231-653 )