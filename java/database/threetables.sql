BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--- USER SETUP (Do Not Modify)
DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;




DROP TABLE IF EXISTS applicants CASCADE;

CREATE TABLE applicants (
	applicant_id serial,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	full_name varchar(50) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	phone_number varchar(10) NOT NULL,
	CONSTRAINT PK_applicant PRIMARY KEY (applicant_id)
);



DROP TABLE IF EXISTS pets CASCADE;

CREATE TABLE pets (
	pet_id serial,
	animal_type varchar(50) NOT NULL,
	gender char(1) NOT NULL,
	pet_name varchar(50) NOT NULL,
	breed varchar(50) NOT NULL,
	age int NOT NULL,
	description text DEFAULT 'Description Coming Soon',
	available boolean DEFAULT true, 
	picture_one varchar(250) DEFAULT 'https://1.bp.blogspot.com/-AzSTfPrkhSY/WkrdSHwgxkI/AAAAAAAAARI/L_3p6sG_CK8UgGpgXyTRXaKtG9O7KUCWACLcBGAs/s320/unnamed.png',
	picture_two varchar(250),
	picture_three varchar(250),
	CONSTRAINT PK_pet PRIMARY KEY (pet_id)
);
--dogs
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES ('dog','m','Max','beagle',3,'Max is a good dog. Great with kids and other dogs. Hates cats.','https://images.unsplash.com/photo-1621219321107-da001e553258?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80');
INSERT INTO pets (animal_type,gender,pet_name,breed, age) VALUES ('dog','m','Sam','pug', 10);
INSERT INTO pets (animal_type,gender,pet_name,breed,age,picture_one) VALUES('dog','f','Aurora', 'dachshund', 6,  
'https://images.unsplash.com/photo-1618265341355-d0e2d1fdf26b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80');
--cats
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('cat','f','Alice', 'british shorthair', 1, 'Alice the British Shorthair! She is super playful and extremely smart.', 
'https://images.unsplash.com/photo-1601808881948-aa68248b1df7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80');
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('cat','m','Tiger', 'bengal',5, 'Tiger loves to chase toys all around the house!', 
'https://images.unsplash.com/photo-1598463166261-357c23778812?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1118&q=80');
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('cat', 'f','Jazz', 'siamese',2, 'Jazz is a sweetheart. She can be both playful and cuddly. It will be love at first sight', 
'https://images.unsplash.com/photo-1568309386325-ef86f13ac533?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80');
--other
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('horse', 'f','Chocolate', 'appaloosa', 2, 'Chocolate is a quick learner with a beautiful brown pattern. She’s great with kids too!', 'https://images.unsplash.com/photo-1518713337836-f828c91becc0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80');
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('pig', 'f','Charlotte', 'american landrace', 2, 'Charlotte is very sweet and clean…for a pig', 'https://images.unsplash.com/photo-1516467508483-a7212febe31a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1173&q=80');
INSERT INTO pets (animal_type,gender,pet_name,breed,age,description,picture_one) VALUES('horse', 'm', 'Snowman', 'camarillo white', 3, 'Snowman is a gentle giant. He is a vegan.', 'https://images.unsplash.com/photo-1553284965-fa61e9ad4795?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80');

DROP TABLE IF EXISTS accounts CASCADE;

CREATE TABLE accounts(
	account_id serial UNIQUE,
	previous_id int NOT NULL UNIQUE,
	aUser_id int NOT NULL,
	CONSTRAINT PK_account PRIMARY KEY (account_id),
	CONSTRAINT FK_account FOREIGN KEY (previous_id) REFERENCES applicants (applicant_id),
	CONSTRAINT FK_user FOREIGN KEY (aUser_id) REFERENCES users (user_id)
);

DROP TABLE IF EXISTS adoption_applications CASCADE;

CREATE TABLE adoption_applications(
	adoption_application_id serial UNIQUE,
	adoption_application_pet_id int NOT NULL,
	adopter_email VARCHAR(250) NOT NULL,
	adopter_phone_number VARCHAR(10) NOT NULL,
	adopter_name VARCHAR(250) NOT NULL,
	adoption_status VARCHAR(250),
	CONSTRAINT PK_adoption_application_id PRIMARY KEY (adoption_application_id),
	CONSTRAINT FK_adoption_pet_id FOREIGN KEY (adoption_application_pet_id) REFERENCES pets (pet_id) 
);

--adoption_date?
--CREATE TABLE adoptions(
--adoption_id serial UNIQUE NOT NULL,
--application_number int NOT NULL UNIQUE,
--CONSTRAINT PK_adoptions_id PRIMARY KEY (adoption_id),
--CONSTRAINT FK_adoption_application_id FOREIGN KEY (application_number) REFERENCES adoption_applications (adoption_application_id)
--);

COMMIT TRANSACTION;

select * from pets;