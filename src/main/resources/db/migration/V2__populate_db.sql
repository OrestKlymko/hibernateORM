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


INSERT INTO planet (id, NAME)
VALUES ('MARS', 'Mars Planet'),
       ('VEN', 'Venus Planet'),
       ('PLUTO', 'Pluto Planet'),
       ('EARTH', 'Earth Planet'),
       ('NEPTUNE', 'Neptune Planet');


INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2023-07-21 12:00:00', 1, 'MARS', 'EARTH'),
       ('2023-07-21 12:30:00', 2, 'EARTH', 'NEPTUNE'),
       ('2023-07-21 13:00:00', 3, 'PLUTO', 'EARTH'),
       ('2023-07-21 13:30:00', 4, 'VEN', 'NEPTUNE'),
       ('2023-07-21 14:00:00', 5, 'VEN', 'PLUTO'),
       ('2023-07-21 14:30:00', 1, 'MARS', 'NEPTUNE');


