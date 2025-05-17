
CREATE TABLE categories (
  CategorieId int NOT NULL primary key,
  CategorieName varchar(50) NOT NULL
);

CREATE TABLE services (
  ServiceId int NOT NULL primary key,
  ServiceName varchar(50) NOT NULL,
  ServiceType varchar(50) NOT NULL,
  Price double NOT NULL,
  CategorieId int,
   FOREIGN KEY (CategorieId) 
   REFERENCES categories (CategorieId) ON DELETE CASCADE ON UPDATE RESTRICT
);
CREATE TABLE preson (
  Id int NOT NULL primary key,
  Fname varchar(50) NOT NULL,
  Lname varchar(50) NOT NULL,
  Genader varchar(50) NOT NULL,
  Type varchar(50) NOT NULL,
  UserName varchar(50) NOT NULL,
  Password varchar(50) NOT NULL
);
-- 
CREATE TABLE admin (
  Id int NOT NULL primary key,
  Jop varchar(50) NOT NULL,
CONSTRAINT presonPK
	FOREIGN KEY (Id)
	REFERENCES preson (Id) ON DELETE CASCADE ON UPDATE RESTRICT
);
CREATE TABLE customer (
  Id int NOT NULL primary key,
  Phone varchar(50) not  NULL,
  Address varchar(50) not NULL,
  Age int NOT NULL,
CONSTRAINT PresonFK
	FOREIGN KEY (Id)
	REFERENCES preson (Id) ON DELETE CASCADE ON UPDATE RESTRICT
); 

CREATE TABLE stadiums (
  StadiumID int NOT NULL primary key,
  StadiumName varchar(50) NOT NULL,
  City varchar(50) NOT NULL,
  NumberSteas int DEFAULT NULL,
  NumberOfParks int NOT NULL
);


CREATE TABLE teams (
  TeamID int NOT NULL primary key ,
  TeamName varchar(50) NOT NULL,
  DateOfEstablishment date DEFAULT NULL,
  Loaction varchar(50) DEFAULT NULL
);


CREATE TABLE footballmatch (
  MatchNumber int NOT NULL primary key,
  Home_Team int NOT NULL,
  Away_Team int NOT NULL,
  DateMatch date NOT NULL,
  TimeMatch time DEFAULT NULL,
  Status int NOT NULL,
  StadiumID int NOT NULL,
CONSTRAINT StadiumFK
	FOREIGN KEY (StadiumID)	REFERENCES stadiums (StadiumID) ON DELETE CASCADE ON UPDATE RESTRICT
);


CREATE TABLE tickets (
  TicketId int NOT NULL primary key ,
  Type varchar(50) NOT NULL,
  NumberOfTickts int NOT NULL,
  MatchNumber int NOT NULL,
  Price decimal(10,0) NOT NULL,
CONSTRAINT footballmatchFK
	FOREIGN KEY (MatchNumber)	REFERENCES 
footballmatch (MatchNumber) ON DELETE CASCADE ON UPDATE RESTRICT
);


CREATE TABLE matchticket (
  MatchTicketId int NOT NULL primary key,
  TicketId int NOT NULL,
  CustomerId int NOT NULL,
  SeatesId int NOT NULL,
  ParksId int NOT NULL
,CONSTRAINT TicketFK
	FOREIGN KEY (TicketId)	REFERENCES 
tickets (TicketId) ON DELETE CASCADE ON UPDATE RESTRICT,
CONSTRAINT CustomerFK
	FOREIGN KEY (CustomerId)	REFERENCES 
customer (Id) ON DELETE CASCADE ON UPDATE RESTRICT

); 


CREATE TABLE invoice (
  InvoiceId int NOT NULL primary key,
  MatchITicketId int NOT NULL,
  Count int DEFAULT NULL,
  ServiceId int NOT NULL,
 CONSTRAINT matchticketFKn
 	FOREIGN KEY (MatchITicketId)	REFERENCES 
 matchticket (MatchTicketId) ON DELETE CASCADE ON UPDATE RESTRICT
); 

CREATE TABLE payment (
  PaymentId int NOT NULL primary key,
  MatchTicketId int NOT NULL,
  Date date DEFAULT NULL,
CONSTRAINT matchticketPayFK
	FOREIGN KEY (MatchTicketId)	REFERENCES 
 matchticket (MatchTicketId) ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE paymentcach (
  PaymentId int NOT NULL primary key,
  Amount double NOT NULL,
CONSTRAINT paymentCachFK
	FOREIGN KEY (PaymentId)
	REFERENCES payment (PaymentId) ON DELETE CASCADE ON UPDATE RESTRICT
);


CREATE TABLE paymentcard (
  PaymentId int NOT NULL primary key,
  cardNumber int NOT NULL,
  CardName varchar(50) NOT NULL,
  Amount decimal(10,0) NOT NULL,
CONSTRAINT paymentCardFK
	FOREIGN KEY (PaymentId)
	REFERENCES payment (PaymentId) ON DELETE CASCADE ON UPDATE RESTRICT
);



INSERT INTO stadiums (StadiumID, StadiumName, City, NumberSteas, NumberOfParks) 
VALUES
(1, 'King Abdullah sport City', 'Jeddah', 65000, 4000),
(3, 'King Fahad Internaional', 'Jeddah', 30000, 0),
(5, 'prince mohamed bin fahad', 'Jeddah', 20000, 599),
(6, 'King abdul Aziz', 'Riyadh', 25000, 220),
(7, 'Mrsool Park', 'makat almukarama', 20000, 0),
(8, 'Prince Faisal bin Fahd Stadium ', 'Riyadh', 22000, 0),
(9, 'Prince Abdullah Al Faisal Stadium ', 'Dammam', 30000, 0),
(10, 'King Abdullah Sport City Stadium ', 'dammam', 15000, 0),
(11, 'Prince Mohammed bin Abdul Aziz Stadium', 'hayil', 14000, 0),
(12, 'Prince Saud bin Jalawi Stadium', 'altaayif', 22000, 0),
(13, 'Prince Abdul Aziz bin Musaed Stadium', 'eaniza', 21000, 0),
(14, 'Prince Sultan bin Abdul Aziz Stadium', 'dammam', 22000, 12000);


INSERT INTO teams (TeamID, TeamName, DateOfEstablishment, Loaction) 
VALUES
(1, 'Al Nasser ', '1937-01-10', 'Royadh'),
(3, 'Al Hilan', '1945-01-10', 'Riyadh'),
(4, 'Al shabab ', '1927-01-09', 'Riyadh'),
(6, 'Al ahli', '1945-01-16', 'Jeddah'),
(7, 'Ittihad', '1945-01-10', 'Jeddah'),
(8, 'Al fateh ', '1947-01-09', 'Harmah'),
(9, 'Khaleej ', '1947-01-29', ' Al hasa'),
(10, 'Al Qadisiyah', '1948-01-02', 'Saihat'),
(11, 'Al Read', '1948-01-16', 'Khobar'),
(12, 'Al Taawon ', '1954-01-02', 'Buradidah'),
(15, 'Al wehda ', '1956-01-10', 'Buraidah'),
(16, 'Hajer ', '1957-01-11', 'Al hasa'),
(18, 'Najran', NULL, 'Najran');


INSERT INTO preson (Id, Fname, Lname, Genader, Type, UserName, Password) 
VALUES
(30, 'Ahamed', 'Ali', 'Male', 'Admin', 'aaav', '1558'),
(2, 'Kaheld', 'Samai', 'Male', 'Customer', 'aaaa', '1234'),
(3, 'Dana  ', 'Almoatib', 'Female', 'Admin', 'dan', '1234'),
(4, 'Ream', 'Alobid', 'Female', 'Admin', 'ream', '54655'),
(5, 'Ibraheem', 'anas', 'Male', 'Customer', '7sjkdhj', 'dkdk'),
(6, 'Ibraheem', 'anas', 'Male', 'Customer', '7sjkdhj', 'dkdk'),
(7, 'nora', 'mohamed', 'Female', 'Customer', 'skdk', 'kkjkj'),
(8, 'Ibraheem', 'moh', 'Female', 'Customer', 'sdd', '1234'),
(9, 'Razan', 'Almadan', 'Female', 'Admin', 'razan', 'razan'),
(10, 'rose', 'Hummusani', 'Female', 'Admin', 'rose', 'rose'),
(11, 'Jenan', 'Albuzaid ', 'Female', 'Admin', 'jenan', 'jenan'),
(12, 'Eiman ', 'Alqahtani ', 'Female', 'Admin', 'ee12', '1234'),
(13, 'Rawan ', 'Alhashem  ', 'Female', 'Admin', 'rawa', '1234'),
(14, 'Raghed ', 'Aljassim  ', 'Female', 'Admin', 'ragh22', '1234'),
(15, 'Nouf ', 'Alsagour  ', 'Female', 'Admin', 'nouf', '1234'),
(16, 'khalid', 'mohamed', 'Male', 'Customer', 'kh12', '1234'),
(17, 'reem', 'ahmed', 'Female', 'Customer', 'reem23', '1234'),
(18, 'rana', 'yousif', 'Female', 'Customer', 'rano','’1234'),
(19, 'Sara', 'alfaisal', 'Female', 'Customer', 'sara12', '1234'),
(20, 'fahad', 'mohamed', 'Female', 'Customer', 'fah2', '1234');




INSERT INTO admin ( Id , Jop )
VALUES
(30, 'Manager'),
(3,'Engeneer'),
(4,'Engeneer'),
(9, 'Manager'),
(10, 'Manager'),
(11, 'developer'),
(12, 'Manager'),
(13, 'Manager'),
(14, 'Manager'),
(15, 'Manager');


INSERT INTO customer (Id, Phone, Address, Age) 
VALUES
(2, '56558332', 'Aldammam', 25),
(6, '58588744', 'Aldammam', 25),
(5, '56982888', 'jeddah', 22),
(7, '55889903', 'jeddah', 22),
(8, '58465555', 'al hasa', 22),
(16, '58465544', 'al hasa', 26),
(17, '58465533', 'riyadh', 25),
(18, '58465522', 'riyadh', 27),
(19, '584655874', 'khobar', 28),
(20, '58465580', 'dhahran', 23);





INSERT INTO footballmatch (MatchNumber, Home_Team, Away_Team, DateMatch, TimeMatch, Status, StadiumID) 
VALUES
(3, 1, 11, '2023-01-07', '11:18:06', 1, 1),
(6, 1, 6, '2023-01-10', '05:06:54', 1, 1),
(8, 8, 4, '2023-01-31', '05:06:54', 1, 12),
(9, 7, 9, '2023-01-18', '05:06:54', 1, 11),
(10, 9, 12, '2023-01-10', '05:06:54', 1, 12);


INSERT INTO tickets (TicketId, Type, NumberOfTickts, MatchNumber, Price) 
VALUES
(1, 'Vip', 323, 3, 32),
(2, 'Normal', 32, 3, 23),
(3, 'Vip', 323, 6, 32),
(4, 'Normal', 32, 6, 23),
(5, 'Vip', 323, 8, 32),
(6, 'Normal', 32, 8, 23),
(7, 'Vip', 323, 9, 32),
(8, 'Normal', 32, 9, 23),
(9, 'Vip', 323, 10, 32),
(10, 'Normal', 32, 10, 23);




INSERT INTO matchticket (MatchTicketId, TicketId, CustomerId, SeatesId, ParksId) 
VALUES
(14, 9, 2, 457, 55);





INSERT INTO categories (CategorieId, CategorieName) 
VALUES
(1, 'drinks'),
(2, 'sandwiches'),
(3, 'Foods'),
(4, 'Other services');
INSERT INTO services (ServiceId, ServiceName, ServiceType, CategorieId, Price) 
VALUES
(1, 'Lemon juice', 'Not free', 1, 10),
(2, 'fruit juice', 'Not free', 1, 15),
(3, 'Water', 'Not free', 2, 555),
(4, 'Hamburger', 'Not free', 2, 12),
(5, 'Shawarma', 'Not free', 2, 15),
(6, 'rice', 'Not free', 3, 16);











