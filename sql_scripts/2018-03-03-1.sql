CREATE TABLE "public".dict_country (
	country_id int8 NOT NULL,
	code varchar(3) NULL,
	abbr varchar(3) NULL,
	name varchar(100) NOT null,
	PRIMARY KEY (country_id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE "public".dict_city (
	city_id int8 NOT NULL,
	country_id int8 not null,
	"name" varchar(100) NOT null,
	PRIMARY KEY (city_id),
	FOREIGN KEY (country_id) REFERENCES dict_country(country_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE "public".client_info (
	info_id bigserial NOT NULL,
	"name" varchar(150) NOT null,
	country_id int8,
	city_id int8,
	street varchar(100),
	home varchar(20),
	apt varchar(20),
	ceo_firstname varchar(100),
	ceo_surname varchar(100),
	ceo_patronymic varchar(100),
	bik varchar(20),
	iik varchar(20),
	prefix int,
	phone int,
	iin_bin varchar(20),
	license_num varchar(20),
	license_date date,
	PRIMARY KEY (info_id),
	FOREIGN KEY (country_id) REFERENCES dict_country(country_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (city_id) REFERENCES dict_city(city_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
	OIDS=FALSE
) ;

ALTER TABLE "public".clients DROP COLUMN reg_date ;
ALTER TABLE "public".clients ADD info_id int8 NULL ;