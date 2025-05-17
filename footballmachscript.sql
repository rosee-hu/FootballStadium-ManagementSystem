
CREATE TABLE categories (
  CategorieId int NOT NULL primary key,
  CategorieName varchar(50) NOT NULL
);

CREATE TABLE services (
  ServiceId int NOT NULL primary key,
  ServiceName varchar(50) NOT NULL,
  ServiceType varchar(50) NOT NULL,
  Price double NOT NULL,
CategorieId INT CONSTRAINT CategorieId_foreign_key
	REFERENCES categories ON DELETE CASCADE ON UPDATE RESTRICT


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