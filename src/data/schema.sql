CREATE TABLE Rooms (
    roomId INTEGER PRIMARY KEY,
    hotelId int PRIMARY KEY,
    roomRank int(1) NOT NULL CHECK(roomRank IN (1,2,3,4)),
    price int NOT NULL,
    arrivalTime DATE NOT NULL,
    numberOfBeds int(2) NOT NULL,
    petFriendly BOOLEAN NOT NULL CHECK(petFriendly IN (0,1)),
    familyFriendly BOOLEAN NOT NULL CHECK(familyFriendly IN (0,1)),
    booked BOOLEAN NOT NULL CHECK(booked IN (0,1)),
    FOREIGN KEY(hotelId) REFERENCES Hotels(hotelId)
);

CREATE TABLE Hotels (
    hotelId INTEGER PRIMARY KEY,
    hotelName varchar(128) NOT NULL,
    country varchar(128) NOT NULL,
    hotelAddress varchar(256) NOT NULL
);

CREATE TABLE Reviews (
    hotelId int PRIMARY KEY,
    userId int PRIMARY KEY,
    reviewText varchar(2000),
    rating int(1) NOT NULL CHECK(rating IN(1,2,3,4,5)),
    FOREIGN KEY(hotelId) REFERENCES Hotels(hotelId),
    FOREIGN KEY(userId) REFERENCES Users(userId)
);

CREATE TABLE Users (
    userId INTEGER PRIMARY KEY,
    email varchar(64) NOT NULL,
    phone varchar(20) NOT NULL,
    username varchar(32) NOT NULL,
    isAdmin BOOLEAN NOT NULL CHECK(isAdmin in (0,1))
);