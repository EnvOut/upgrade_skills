CREATE TABLE Car(
  ID SERIAL NOT NULL ,
  License_plate VARCHAR(20) NOT NULL ,
  Manufacturer VARCHAR(20) NOT NULL ,
  Manufacture_date DATE NOT NULL ,
  Age INT NOT NULL DEFAULT 0,
  Version INT NOT NULL DEFAULT 0,
  UNIQUE (License_plate),
  PRIMARY KEY (id)
);
INSERT INTO Car (License_plate, Manufacturer, Manufacture_date)
  VALUES ('License-1001', 'Ford', '1980-07-30');
INSERT INTO Car (License_plate, Manufacturer, Manufacture_date)
  VALUES ('License-1002', 'Toyota', '1992-12-30');
INSERT INTO Car (License_plate, Manufacturer, Manufacture_date)
  VALUES ('License-1003', 'BMW', '2003-1-6');