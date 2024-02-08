DROP TABLE IF EXISTS TEST;
DROP TABLE IF EXISTS FOLLOWUP;
DROP TABLE IF EXISTS ASSIGNMENT;
DROP TABLE IF EXISTS TODO;
DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE TEST(
  test_id INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE EMPLOYEE (
  employee_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  status boolean
);

CREATE TABLE TODO (
  todo_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  completed_at TIMESTAMP NULL  
);

CREATE TABLE ASSIGNMENT (
  assignment_id INT AUTO_INCREMENT PRIMARY KEY,
  todo_id INT NOT NULL,
  assigned_to INT NOT NULL, 
  assigned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  -- PRIMARY KEY(todo_id, assigned_to),
  FOREIGN KEY (todo_id) REFERENCES TODO(todo_id),
  FOREIGN KEY (assigned_to) REFERENCES EMPLOYEE(employee_id)
);

CREATE TABLE FOLLOWUP (
  followup_id INT AUTO_INCREMENT PRIMARY KEY,
  todo_id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  created_by INT NOT NULL, 
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (todo_id) REFERENCES TODO(todo_id),
  FOREIGN KEY (created_by) REFERENCES EMPLOYEE(employee_id)
);