CREATE TABLE client
(
    ID INT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(200) CHECK (LENGTH(NAME) >= 3 AND LENGTH(NAME) <= 200),
    PRIMARY KEY(ID)
);

CREATE TABLE planet
(
    ID INT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(500) CHECK (LENGTH(NAME) >= 1 AND LENGTH(NAME) <= 500),
    PRIMARY KEY(ID)
);

CREATE TABLE ticket
(
    ID INT AUTO_INCREMENT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id INT NOT NULL,
    to_planet_id INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(ID),
    FOREIGN KEY (from_planet_id) REFERENCES planet(ID),
    FOREIGN KEY (to_planet_id) REFERENCES planet(ID)
);
