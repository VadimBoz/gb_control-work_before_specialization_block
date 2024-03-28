CREATE SCHEMA IF NOT EXISTS `Human_Friends`;
USE `Human_Friends`;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Pets ;
SET foreign_key_checks = 1;

CREATE TABLE Pets  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    Type VARCHAR(20) NOT NULL,
    BirthDate DATE
);

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS PackAnimals ;
SET foreign_key_checks = 1;

CREATE TABLE PackAnimals  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20) NOT NULL,
    Type VARCHAR(20) NOT NULL,
    BirthDate DATE
);

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Commands ;
SET foreign_key_checks = 1;

CREATE TABLE Commands  (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Command VARCHAR(30)
);

DROP TABLE IF EXISTS Pets_Commands;

CREATE TABLE Pets_Commands (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Pets INT,
    ID_Command INT,
    CONSTRAINT Pets_fk
       FOREIGN KEY (ID_Pets)  REFERENCES Pets (ID),
    CONSTRAINT Pets_Commands_fk
       FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);

DROP TABLE IF EXISTS PackAnimals_Commands;

CREATE TABLE PackAnimals_Commands (
      ID INT AUTO_INCREMENT PRIMARY KEY,
      ID_PackAnimals INT,
      ID_Command INT,
      CONSTRAINT PackAnimals_fk
          FOREIGN KEY (ID_PackAnimals)  REFERENCES PackAnimals (ID),
      CONSTRAINT PackAnimals_Commands_fk
          FOREIGN KEY (ID_Command)  REFERENCES Commands (ID)
);


INSERT INTO Pets (Name, Type, BirthDate) VALUES
     ('Fido','Dog', '2020-01-01'),
     ('Whiskers','Cat', '2019-05-15'),
     ('Hammy', 'Hamster', '2021-03-10'),
     ('Buddy', 'Dog','2018-12-10'),
     ('Smudge', 'Cat', '2020-02-20'),
     ('Peanut', 'Hamster', '2021-08-01'),
     ('Bella', 'Dog', '2019-11-11'),
     ('Oliver', 'Cat', '2020-06-30');


INSERT INTO PackAnimals (Name, Type, BirthDate) VALUES
    ('Thunder',	'Horse', '2015-07-21'),
    ('Sandy', 'Camel', '2016-11-03'),
    ('Eeyore', 'Donkey', '2017-09-18'),
    ('Storm', 'Horse', '2014-05-05'),
    ('Dune', 'Camel', '2018-12-12'),
    ('Burro', 'Donkey', '2019-01-23'),
    ('Blaze', 'Horse', '2016-02-29'),
    ('Sahara', 'Camel', '2015-08-14');

INSERT INTO Commands (Command) VALUES
    ('Sit'), -- 1
    ('Stay'), -- 2
    ('Fetch'),  -- 3
    ('Pounce'), -- 4
    ('Roll'), -- 5
    ('Hide'), -- 6
    ('Paw'), -- 6
    ('Bark'), -- 8
    ('Scratch'), -- 9
    ('Spin'), -- 10
    ('Trot'),  -- 11
    ('Canter'), --  12
    ('Gallop'),  -- 13
    ('Carry Load'), -- 14
    ('Walk'),  -- 15
    ('Bray'),  -- 16
    ('Kick'),  -- 17
    ('Jump'),  -- 18
    ('Run'), -- 19
    ('Meow');

INSERT INTO Pets_Commands (ID_Pets, ID_Command) VALUES
    (1, 1), (1, 2), (1, 3),
    (2, 1), (2, 4),
    (3, 5), (3, 6),
    (4, 1), (4, 6), (4, 8),
    (5, 1), (5, 6), (5, 9),
    (6, 5), (6, 10),
    (7, 1), (7, 2), (7, 5),
    (8, 20), (8, 9), (8, 18);


INSERT INTO PackAnimals_Commands (ID_PackAnimals, ID_Command) VALUES
    (1, 11), (1, 12), (1, 13),
    (2, 15), (2, 14),
    (3, 15), (3, 14), (3, 16),
    (4, 11), (4, 12),
    (5, 15), (5, 1),
    (6, 15), (6, 16), (6, 17),
    (7, 11), (7, 18), (7, 13),
    (8, 15), (8, 19);

SELECT CONCAT(Pets.ID, " Pets") As "ID Animal", Name, Type, BirthDate, Command, COUNT(Command)
        OVER (PARTITION BY Pets.ID ORDER BY Pets.ID) AS Count_Commands FROM Pets
    JOIN Pets_Commands ON Pets.ID = Pets_Commands.ID_Pets
    JOIN Commands ON Pets_Commands.ID_Command = Commands.ID
UNION
SELECT CONCAT( PackAnimals.ID, " PackAnimals") AS "ID Animal", Name, Type, BirthDate, Command, COUNT(Command)
        OVER (PARTITION BY PackAnimals.ID ORDER BY PackAnimals.ID) AS Count_Commands FROM PackAnimals
    JOIN PackAnimals_Commands ON PackAnimals.ID = PackAnimals_Commands.ID_PackAnimals
    JOIN Commands ON PackAnimals_Commands.ID_Command = Commands.ID;