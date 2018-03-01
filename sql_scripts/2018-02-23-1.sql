CREATE TABLE "public"."employees" (
	emp_id bigserial NOT NULL,
	client_id int8 NOT NULL,
	firstName varchar(250) NOT NULL,
	surname varchar(250),
	patronymic varchar(250),
	phone int8,
	position_id int8,
	description text,
	PRIMARY KEY (emp_id),
	FOREIGN KEY (client_id) REFERENCES clients(client_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
	FOREIGN KEY (position_id) REFERENCES position(position_id) ON UPDATE RESTRICT ON DELETE SET NULL
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE "public"."branch" (
	branch_id bigserial NOT NULL,
	client_id int8 NOT NULL,
	name varchar(100) NOT NULL,
	phone int8,
	street varchar(100),
	home varchar(100),
	apt varchar(100),
	description text,
	PRIMARY KEY (branch_id),
	FOREIGN KEY (client_id) REFERENCES clients(client_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
	OIDS=FALSE
);


CREATE TABLE "public".branch_employees_ref (
	branch_id int8 NOT NULL,
	emp_id int8 NOT NULL,
	PRIMARY KEY (branch_id, emp_id),
	FOREIGN KEY (branch_id) REFERENCES branch(branch_id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (emp_id) REFERENCES employees(emp_id) ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
	OIDS=FALSE
);