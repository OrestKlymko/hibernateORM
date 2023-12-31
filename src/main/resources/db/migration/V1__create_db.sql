CREATE TABLE client
(
    ID INT AUTO_INCREMENT NOT NULL,
    NAME VARCHAR(200) CHECK (LENGTH(NAME) >= 3 AND LENGTH(NAME) <= 200),
    PRIMARY KEY(ID)
);

CREATE TABLE planet
(
    ID VARCHAR(50) PRIMARY KEY,
    NAME VARCHAR(500) CHECK (LENGTH(NAME) >= 1 AND LENGTH(NAME) <= 500)
);

CREATE TABLE ticket
(
    ID INT AUTO_INCREMENT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(50) NOT NULL,
    to_planet_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(ID) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planet(ID),
    FOREIGN KEY (to_planet_id) REFERENCES planet(ID)
);
