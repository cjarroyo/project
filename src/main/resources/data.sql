DROP TABLE IF EXISTS money;

CREATE TABLE money (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  short_description VARCHAR(250) NOT NULL,
  long_description VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS type_changed;

CREATE TABLE type_changed (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  source_money INT NOT NULL,
  target_money INT NOT NULL,
  change DECIMAL NOT NULL
);

INSERT INTO money (short_description, long_description) VALUES
  ('SOL', 'Soles'),
  ('DOL', 'Dolares'),
  ('EUR', 'Euros'),
  ('PES', 'Pesos'),
  ('YEN', 'Yenes');

INSERT INTO type_changed (source_money, target_money, change) VALUES
  (1, 2, 3.35),
  (2, 1, 3.33),
  (1, 3, 4.83),
  (4, 1, 5.48);