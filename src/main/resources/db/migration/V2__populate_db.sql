INSERT INTO client (NAME)
VALUES ('Client 1'),
       ('Client 2'),
       ('Client 3'),
       ('Client 4'),
       ('Client 5'),
       ('Client 6'),
       ('Client 7'),
       ('Client 8'),
       ('Client 9'),
       ('Client 10');


INSERT INTO planet (NAME)
VALUES ('MARS'),
       ('VENUS'),
       ('EARTH'),
       ('JUPITER'),
       ('NEPTUNE');


INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2023-07-21 12:00:00', 1, 1, 3),
       ('2023-07-21 12:30:00', 2, 2, 1),
       ('2023-07-21 13:00:00', 3, 3, 2),
       ('2023-07-21 13:30:00', 4, 4, 5),
       ('2023-07-21 14:00:00', 5, 5, 4),
       ('2023-07-21 14:30:00', 1, 3, 2);


INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2023-07-21 14:30:00', 6, 1, 4),
       ('2023-07-21 15:00:00', 7, 2, 5),
       ('2023-07-21 15:30:00', 8, 3, 1),
       ('2023-07-21 16:00:00', 9, 4, 2),
       ('2023-07-21 16:30:00', 10, 5, 3);
