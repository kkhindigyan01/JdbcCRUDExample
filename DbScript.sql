CREATE TABLE employee (
  employee_id int NOT NULL AUTO_INCREMENT,
  employee_name varchar(60) NOT NULL,
  employee_salary double DEFAULT '0',
  employee_dept varchar(30) DEFAULT NULL,
  employee_doj date NOT NULL,
  PRIMARY KEY (employee_id)
) ;

INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('John',5000,'IT','2021-01-20');
INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('Sean',9000,'Operation','2021-01-22');
INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('Tom',4000,'Admin','2021-01-25');


