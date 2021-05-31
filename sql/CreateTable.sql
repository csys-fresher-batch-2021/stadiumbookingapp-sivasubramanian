/*create table for users*/
create table users(
id serial primary key,
user_name varchar(100) NOT NULL,
password varchar(100) NOT NULL,
mobile_number bigint NOT NULL
);


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
    PRIMARY KEY (id)
);
