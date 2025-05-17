

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


INSERT INTO teams (TeamID, TeamName, DateOfEstablishment, Loaction) 
VALUES
(1, 'al\ahli ', '1937-01-10', 'jidat , maka'),
(3, 'alwahdat ', '1945-01-10', 'maka'),
(4, 'aliaitihad ', '1927-01-09', 'jidat , maka'),
(6, 'alkhalij ', '1945-01-16', 'sihat , almintaqat alsharqia'),
(7, 'alaitifaq ', '1945-01-10', 'aldamaam , almintaqat alsharqia'),
(8, 'alshabab ', '1947-01-09', 'alriyad'),
(9, 'hajr ', '1947-01-29', ' alhufuf , alahsa'),
(10, 'altahami', '1948-01-02', 'jizan , mintaqat jazan'),
(11, 'alsafa', '1948-01-16', 'safwaa , almintaqat alsharqia'),
(12, 'alraayid ', '1954-01-02', 'buraydat , alqasim'),
(15, 'altaeawun ', '1956-01-10', 'buraydat , alqasim'),
(16, 'alhilal ', '1957-01-11', 'alriyad '),
(18, 'sdfsdf', NULL, 'dsdfdf');


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


INSERT INTO admin ( Id , Jop )
VALUES
(1, 'Mang'),
(2, 'razan');





INSERT INTO customer (Id, Phone, Address, Age) 
VALUES
(2, '56558', 'Aldamam', 25),
(3, '585887', 'Aldamam', 25),
(4, '56982888', 'jadh', 22),
(7, 'jkjk', 'kjjkjk', 22),
(8, '584655', 'jadh', 22);





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








