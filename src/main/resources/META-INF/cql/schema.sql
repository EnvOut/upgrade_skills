DROP TABLE if EXISTS contact;

CREATE TABLE contact (
  id SERIAL NOT NULL ,
  first_name VARCHAR(60) NOT NULL ,
  last_name VARCHAR(60) NOT NULL ,
  birth_date Date ,
  version int NOT NULL DEFAULT 0,
  UNIQUE (first_name, last_name),
  PRIMARY KEY (id)
)