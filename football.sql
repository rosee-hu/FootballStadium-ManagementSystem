





CREATE TABLE admin (
  Id int NOT NULL primary key,
  Jop varchar(50) NOT NULL
);
-- ENGINE =InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO admin ( Id , Jop )
VALUES
(1, 'Mang'),
(2, 'razan');



CREATE TABLE categories (
  CategorieId int NOT NULL primary key,
  CategorieName varchar(50) NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO categories (CategorieId, CategorieName) 
VALUES
(1, 'drinks'),
(2, 'sandwiches'),
(3, 'Foods'),
(4, 'Other services');



CREATE TABLE customer (
  Id int NOT NULL primary key,
  Phone varchar(50) not  NULL,
  Address varchar(50) not NULL,
  Age int NOT NULL
); 
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


INSERT INTO customer (Id, Phone, Address, Age) 
VALUES
(2, '56558', 'Aldamam', 25),
(3, '585887', 'Aldamam', 25),
(4, '56982888', 'jadh', 22),
(7, 'jkjk', 'kjjkjk', 22),
(8, '584655', 'jadh', 22);


CREATE TABLE footballmatch (
  MatchNumber int NOT NULL primary key,
  Home_Team int NOT NULL,
  Away_Team int NOT NULL,
  DateMatch date NOT NULL,
  TimeMatch time DEFAULT NULL,
  Status int NOT NULL,
  StadiumID int NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO footballmatch (MatchNumber, Home_Team, Away_Team, DateMatch, TimeMatch, Status, StadiumID) 
VALUES
(3, 1, 11, '2023-01-07', '11:18:06', 1, 1),
(6, 1, 6, '2023-01-10', '05:06:54', 1, 1),
(8, 8, 4, '2023-01-31', NULL, 1, 12),
(9, 7, 9, '2023-01-18', NULL, 1, 11),
(10, 9, 12, '2023-01-10', NULL, 1, 12);



CREATE TABLE invoice (
  InvoiceId int NOT NULL primary key,
  MatchITicketId int NOT NULL,
  Count int DEFAULT NULL,
  ServiceId int NOT NULL
); 
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



CREATE TABLE matchticket (
  MatchTicketId int NOT NULL primary key,
  TicketId int NOT NULL,
  CustomerId int NOT NULL,
  SeatesId int NOT NULL,
  ParksId int NOT NULL
); 
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO matchticket (MatchTicketId, TicketId, CustomerId, SeatesId, ParksId) 
VALUES
(14, 9, 2, 457, 55);



CREATE TABLE payment (
  PaymentId int NOT NULL primary key,
  MatchTicketId int NOT NULL,
  Date date DEFAULT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



CREATE TABLE paymentcach (
  PaymentId int NOT NULL primary key,
  Amount double NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



CREATE TABLE paymentcard (
  PaymentId int NOT NULL primary key,
  cardNumber int NOT NULL,
  CardName varchar(50) NOT NULL,
  Amount decimal(10,0) NOT NULL
);
--  ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



CREATE TABLE preson (
  Id int NOT NULL primary key,
  Fname varchar(50) NOT NULL,
  Lname varchar(50) NOT NULL,
  Genader varchar(50) NOT NULL,
  Type varchar(50) NOT NULL,
  UserName varchar(50) NOT NULL,
  Password varchar(50) NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO preson (Id, Fname, Lname, Genader, Type, UserName, Password) 
VALUES
(1, 'Ahamed', 'Ali', 'Male', 'Admin', 'aaav', '1558'),
(2, 'Kaheld', 'Samai', 'Male', 'Customer', 'aaaa', '1234'),
(3, 'Dana  ', 'Almoatib', 'Female', 'Customer', 'dan', '1234'),
(4, 'Ream', 'Alobid', 'Female', 'Customer', 'ream', '54655'),
(5, 'Ibraheem', 'anas', 'Male', 'Customer', '7sjkdhj', 'dkdk'),
(6, 'Ibraheem', 'anas', 'Male', 'Customer', '7sjkdhj', 'dkdk'),
(7, 'jsdk', 'j', 'Female', 'Customer', 'skdk', 'kkjkj'),
(8, 'Ibraheem', 'moh', 'Female', 'Customer', 'sdd', '1234'),
(9, 'skjaldk', 'jjkj', 'Female', 'Customer', 'skdks;', 'njknkkl');



CREATE TABLE services (
  ServiceId int NOT NULL primary key,
  ServiceName varchar(50) NOT NULL,
  ServiceType varchar(50) NOT NULL,
  CategorieId int NOT NULL,
  Price double NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO services (ServiceId, ServiceName, ServiceType, CategorieId, Price) 
VALUES
(1, 'Lemon juice', 'Not free', 1, 10),
(2, 'fruit juice', 'Not free', 1, 15),
(3, 'Water', 'Not free', 2, 555),
(4, 'Hamburger', 'Not free', 2, 12),
(5, 'Shawarma', 'Not free', 2, 15),
(6, 'rice', 'Not free', 3, 16);



CREATE TABLE stadiums (
  StadiumID int NOT NULL primary key,
  StadiumName varchar(50) NOT NULL,
  City varchar(50) NOT NULL,
  NumberSteas int DEFAULT NULL,
  NumberOfParks int NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO stadiums (StadiumID, StadiumName, City, NumberSteas, NumberOfParks) 
VALUES
(1, 'maleab almalik fahd aldawl', 'Riyadh', 20000, 0),
(3, 'maleab almalik eabdallah alduwaliu', 'Jeddah', 30000, 0),
(5, 'aistad al\amir eabd allah alfaysal', 'Jeddah', 20000, 599),
(6, 'maleab al\amir faysal bin fahd', 'Riyadh', 25000, 220),
(7, 'madinat almalik eabdialeaziz alriyadiat', 'makat almukarama', 20000, 0),
(8, 'madinat almalik eabdallah alriyadiat ', 'Riyadh', 22000, 0),
(9, 'maleab al\amir muhamad bin fahd ', 'Dammam', 30000, 0),
(10, 'maleab al\amir eabd allh bin jalawii ', 'al\ahsa', 15000, 0),
(11, 'maleab al\amir eabd aleaziz bin musaeid', 'hayil', 14000, 0),
(12, 'madinat almalik fahd alriyadiat', 'altaayif', 22000, 0),
(13, 'maleab \iidarat altaelim', 'eaniza', 21000, 0),
(14, 'maleab nadi alshuelat', 'maleab nadi alshuelat', 22000, 12000);



CREATE TABLE teams (
  TeamID int NOT NULL primary key ,
  TeamName varchar(50) NOT NULL,
  DateOfEstablishment date DEFAULT NULL,
  Loaction varchar(50) DEFAULT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO teams (TeamID, TeamName, DateOfEstablishment, Loaction) 
VALUES
(1, 'al\ahli ', '1937-01-10', 'jidat , maka'),
(3, 'alwahdat ', '1945-01-10', 'maka'),
(4, 'aliaitihad ', '1927-01-09', 'jidat , maka'),
(6, 'alkhalij ', '1945-01-16', 'sihat , almintaqat alsharqia'),
(7, 'alaitifaq ', '1945-01-10', 'aldamaam , almintaqat alsharqia'),
(8, 'alshabab ', '1947-01-09', 'alriyad'),
(9, 'hajr ', '1947-01-29', ' alhufuf , al\ahsa\'),
(10, 'altahami ', '1948-01-02', 'jizan , mintaqat jazan'),
(11, 'alsafa', '1948-01-16', 'safwaa , almintaqat alsharqia'),
(12, 'alraayid ', '1954-01-02', 'buraydat , alqasim'),
(15, 'altaeawun ', '1956-01-10', 'buraydat , alqasim'),
(16, 'alhilal ', '1957-01-11', 'alriyad '),
(18, 'sdfsdf', NULL, 'dsdfdf');



CREATE TABLE tickets (
  TicketId int NOT NULL primary key ,
  Type varchar(50) NOT NULL,
  NumberOfTickts int NOT NULL,
  MatchNumber int NOT NULL,
  Price decimal(10,0) NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO tickets (TicketId, Type, NumberOfTickts, MatchNumber, Price) 
VALUES
(1, 'Vip', 323, 3, 32),
(2, 'Normal', 32, 3, 23);


--ALTER TABLE admin
  --ADD PRIMARY KEY (Id);


--ALTER TABLE categories
  --ADD PRIMARY KEY (CategorieId);


--ALTER TABLE customer
  --ADD PRIMARY KEY (Id);


ALTER TABLE footballmatch
 -- ADD PRIMARY KEY (MatchNumber),
   ADD foreign KEY HomeTeamsFK (Home_Team);
ALTER TABLE footballmatch
  ADD foreign KEY AweyTeamsFK (Away_Team);
ALTER TABLE footballmatch
  ADD foreign KEY StadiumFK (StadiumID);


ALTER TABLE invoice
 -- ADD PRIMARY KEY (InvoiceId)
  ADD foreign KEY Service (ServiceId);
ALTER TABLE invoice
  ADD foreign KEY fvv (MatchITicketId);


ALTER TABLE matchticket
 -- ADD PRIMARY KEY (MatchTicketId),
  ADD foreign KEY TickesFk (TicketId);
ALTER TABLE matchticket
  ADD foreign KEY Cu (CustomerId);


ALTER TABLE payment
 -- ADD PRIMARY KEY (PaymentId),
  ADD foreign KEY Met (MatchTicketId);


--ALTER TABLE paymentcach
--  ADD PRIMARY KEY (PaymentId);


--ALTER TABLE paymentcard
 -- ADD PRIMARY KEY (PaymentId);


--ALTER TABLE preson
  --ADD PRIMARY KEY (Id);


ALTER TABLE services
 -- ADD PRIMARY KEY (ServiceId),
  ADD foreign KEY categoriesServicePk (CategorieId);


--ALTER TABLE stadiums
 -- ADD PRIMARY KEY (StadiumID);


--ALTER TABLE teams
  --ADD PRIMARY KEY (TeamID);


ALTER TABLE tickets
 -- ADD PRIMARY KEY (TicketId),
  ADD foreign KEY MachFk (MatchNumber);




ALTER TABLE admin
  MODIFY Id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE categories
  MODIFY CategorieId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `footballmatch`
--
ALTER TABLE footballmatch
  MODIFY MatchNumber int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE invoice
  MODIFY InvoiceId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `matchticket`
--
ALTER TABLE matchticket
  MODIFY MatchTicketId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE payment
  MODIFY PaymentId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `preson`
--
ALTER TABLE preson
  MODIFY Id int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE services
  MODIFY ServiceId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `stadiums`
--
ALTER TABLE stadiums
  MODIFY StadiumID int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE teams
  MODIFY TeamID int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tickets`
--
ALTER TABLE tickets
  MODIFY TicketId int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE admin
  ADD CONSTRAINT ad FOREIGN KEY (Id) REFERENCES preson (Id); 
--ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `customer`
--
ALTER TABLE customer
  ADD CONSTRAINT PresonFK FOREIGN KEY (Id) REFERENCES preson (Id);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `footballmatch`
--
ALTER TABLE footballmatch
  ADD CONSTRAINT AweyTeamsFK FOREIGN KEY (Away_Team) REFERENCES teams (TeamID);-- ON DELETE CASCADE ON UPDATE CASCADE,
ALTER TABLE footballmatch
  ADD CONSTRAINT HomeTeamsFK FOREIGN KEY (Home_Team) REFERENCES teams (TeamID); -- ON DELETE CASCADE ON UPDATE CASCADE,
ALTER TABLE footballmatch
  ADD CONSTRAINT StadiumFK FOREIGN KEY (StadiumID) REFERENCES stadiums (StadiumID);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE invoice
  ADD CONSTRAINT Service FOREIGN KEY (ServiceId) REFERENCES services (ServiceId);-- ON DELETE CASCADE ON UPDATE CASCADE,
ALTER TABLE invoice
  ADD CONSTRAINT fvv FOREIGN KEY (MatchITicketId) REFERENCES matchticket (MatchTicketId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `matchticket`
--
ALTER TABLE matchticket
  ADD CONSTRAINT Cu FOREIGN KEY (CustomerId) REFERENCES preson (Id);-- ON DELETE CASCADE ON UPDATE CASCADE,
ALTER TABLE matchticket
  ADD CONSTRAINT TickesFk FOREIGN KEY (TicketId) REFERENCES tickets (TicketId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE payment
  ADD CONSTRAINT Met FOREIGN KEY (MatchTicketId) REFERENCES matchticket (MatchTicketId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentcach`
--
ALTER TABLE paymentcach
  ADD CONSTRAINT payPk FOREIGN KEY (PaymentId) REFERENCES payment (PaymentId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentcard`
--
ALTER TABLE paymentcard
  ADD CONSTRAINT Card FOREIGN KEY (PaymentId) REFERENCES payment (PaymentId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `services`
--
ALTER TABLE services
  ADD CONSTRAINT categoriesServicePk FOREIGN KEY (CategorieId) REFERENCES categories (CategorieId);-- ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tickets`
--
ALTER TABLE tickets
  ADD CONSTRAINT MachFk FOREIGN KEY (MatchNumber) REFERENCES footballmatch (MatchNumber);--ON DELETE CASCADE ON UPDATE CASCADE;
-- COMMIT;

