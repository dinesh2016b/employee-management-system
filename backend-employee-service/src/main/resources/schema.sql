
DROP VIEW IF EXISTS current_dept_emp;
DROP VIEW IF EXISTS dept_emp_latest_date;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dept_emp;
DROP TABLE IF EXISTS dept_manager;
DROP TABLE IF EXISTS titles;
DROP TABLE IF EXISTS salaries;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;
                     
CREATE TABLE roles (
	id BIGINT AUTO_INCREMENT NOT NULL,
  	name VARCHAR(50) NOT NULL,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
	PRIMARY KEY (id)
);

CREATE TABLE users(
	id BIGINT AUTO_INCREMENT NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,	
	email VARCHAR(255) NOT NULL,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
	PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  	user_id BIGINT NOT NULL,
	role_id BIGINT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE employees (
    emp_no      INT             NOT NULL,
    birth_date  DATE            NOT NULL,
    first_name  VARCHAR(20)     NOT NULL,
    last_name   VARCHAR(20)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,    
    hire_date   DATE            NOT NULL,
    is_active   BOOLEAN         DEFAULT TRUE,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
    PRIMARY KEY (emp_no)
);

CREATE TABLE departments (
    dept_no     CHAR(4)         NOT NULL,
    dept_name   VARCHAR(40)     NOT NULL,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
    PRIMARY KEY (dept_no)
    -- ,UNIQUE  KEY (dept_name)
);

CREATE TABLE dept_manager (
   emp_no       INT             NOT NULL,
   dept_no      CHAR(4)         NOT NULL,
   from_date    DATE            NOT NULL,
   to_date      DATE            NOT NULL,
   FOREIGN KEY (emp_no)  REFERENCES employees (emp_no)    ON DELETE CASCADE,
   FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
   PRIMARY KEY (emp_no,dept_no)
); 

CREATE TABLE dept_emp (
    emp_no      INT             NOT NULL,
    dept_no     CHAR(4)         NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    FOREIGN KEY (emp_no)  REFERENCES employees   (emp_no)  ON DELETE CASCADE,
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no,dept_no)
);

CREATE TABLE titles (
    emp_no      INT             NOT NULL,
    title       VARCHAR(50)     NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no,title, from_date)
) 
; 

CREATE TABLE salaries (
    emp_no      INT             NOT NULL,
    salary      INT             NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    created_date DATE default NULL,
    created_by  VARCHAR(20)default NULL,
    updated_date DATE default NULL,
	updated_by VARCHAR(20) default NULL,
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
    PRIMARY KEY (emp_no, from_date)
) 
; 

CREATE OR REPLACE VIEW dept_emp_latest_date AS
    SELECT emp_no, MAX(from_date) AS from_date, MAX(to_date) AS to_date
    FROM dept_emp
    GROUP BY emp_no;

CREATE OR REPLACE VIEW current_dept_emp AS
    SELECT l.emp_no, dept_no, l.from_date, l.to_date
    FROM dept_emp d
        INNER JOIN dept_emp_latest_date l
        ON d.emp_no=l.emp_no AND d.from_date=l.from_date AND l.to_date = d.to_date;
