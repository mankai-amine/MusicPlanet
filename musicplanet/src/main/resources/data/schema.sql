CREATE TABLE IF NOT EXISTS users ( username VARCHAR(50) NOT NULL PRIMARY KEY, password VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS `tracks` (
  `track_id` INT NOT NULL,
  `track_name` VARCHAR(45) NULL,
  `album_id` INT NULL,
  `artist_id` INT NULL,
  PRIMARY KEY (`track_id`));