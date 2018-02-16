CREATE TABLE "public"."position" (
	position_id bigserial NOT NULL,
	client_id int8 NOT NULL,
	"name" varchar(250) NOT NULL,
	description text NULL,
	PRIMARY KEY (position_id),
	FOREIGN KEY (client_id) REFERENCES clients(client_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
	OIDS=FALSE
) ;


CREATE TABLE "public".clients_user_ref (
	client_id int8 NOT NULL,
	user_id int8 NOT NULL,
	PRIMARY KEY (client_id, user_id)
)
WITH (
	OIDS=FALSE
) ;


CREATE TABLE "public".clients (
	client_id bigserial NOT NULL,
	"name" text NOT NULL,
	"regDate" timestamp NOT NULL,
	PRIMARY KEY (client_id)
)
WITH (
	OIDS=FALSE
) ;
