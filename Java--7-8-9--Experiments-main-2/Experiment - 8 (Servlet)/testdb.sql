-- SQL script to create sample database and tables for PBLJ_EXP_8
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

CREATE TABLE IF NOT EXISTS Employee (
  EmpID INT PRIMARY KEY,
  Name VARCHAR(50),
  Salary DECIMAL(10,2)
);

INSERT INTO Employee (EmpID, Name, Salary) VALUES (1, 'Neha', 40000.00) 
ON DUPLICATE KEY UPDATE Name=VALUES(Name), Salary=VALUES(Salary);
INSERT INTO Employee (EmpID, Name, Salary) VALUES (2, 'Ravi', 35000.00)
ON DUPLICATE KEY UPDATE Name=VALUES(Name), Salary=VALUES(Salary);

CREATE TABLE IF NOT EXISTS Attendance (
  StudentID INT,
  Date DATE,
  Status VARCHAR(10)
);

-- Sample attendance row
INSERT INTO Attendance (StudentID, Date, Status) VALUES (1, '2025-10-01', 'Present');
