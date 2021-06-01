/*create table for users*/
create table users(
id serial primary key,
user_name varchar(100) NOT NULL,
password varchar(100) NOT NULL,
mobile_number bigint NOT NULL
);
/*Register User*/
insert into users(user_name,password,mobile_number)
values ('mani','Mani@123',9994440350);



/*For admin login use
Username=admin
password=admin@123*/




/*create table for match details*/
CREATE TABLE match_details
(
    id serial,
    stadium_name character varying(200) NOT NULL,
    match_date date NOT NULL,
    team1 character varying(20) NOT NULL,
    team2 character varying(20) NOT NULL,
    total_seats integer NOT NULL,
    available_seats integer NOT NULL,
    booked_seats integer NOT NULL default 0,
    upper_seat_price integer NOT NULL,
    lower_seat_price integer NOT NULL,
    image character varying(200) NOT NULL,
    PRIMARY KEY (id),
	CHECK (total_seats>0),
	CHECK (available_seats>0),
	CHECK (upper_seat_price>0),
	CHECK (lower_seat_price>0)
);
/*Insert values in match_details*/
insert into match_details (stadium_name,match_date,team1,team2,total_seats,available_seats,upper_seat_price,lower_seat_price,image) 
values ('M. A. Chidambaram Stadium,Chennai','2021-06-10','csk','mi',1000,1000,1500,3000,'csk-mi.jpg');

insert into match_details (stadium_name,match_date,team1,team2,total_seats,available_seats,upper_seat_price,lower_seat_price,image) 
values ('Wankhede Stadium,Mumbai','2021-06-11','dc','pk',800,800,2000,4000,'dc-pk.jpg');

insert into match_details (stadium_name,match_date,team1,team2,total_seats,available_seats,upper_seat_price,lower_seat_price,image) 
values ('Eden Gardens,Kolkata','2021-06-12','rcb','srh',1500,1500,2500,3800,'rcb-srh.jpg');





/*Booking table*/
CREATE TABLE booking_details
(
    user_id integer,
    match_id integer,
    seat_type character varying(50) NOT NULL,
    no_of_seats integer NOT NULL,
    booking_date date NOT NULL DEFAULT CURRENT_DATE,
    total_amount integer NOT NULL,
    status character varying(100) NOT NULL DEFAULT 'booked',
    FOREIGN KEY (user_id) REFERENCES users (id),
	FOREIGN KEY (match_id) REFERENCES match_details (id),
	CHECK (total_amount>0),
	CHECK (no_of_seats>0)
);
