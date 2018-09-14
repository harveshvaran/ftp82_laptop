-- change this to your team id
use ftp82;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table

CREATE TABLE EMPLOYEE(EMP_ID INT PRIMARY KEY,EMP_NAME VARCHAR(20),EMP_PHBIGINT,EMP_EMAIL VARCHAR(20),EMP_DEPT VARCHAR(20),EMP_MANAGER_ID INT,EMP_LEAVE_BALANCE INT,EMP_DOJ DATE);

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK FOREIGN KEY(EMP_MANAGER_ID) REFERENCES EMPLOYEE(EMP_ID);

CREATE TABLE LEAVE_DETAILS(LEAVE_ID INT PRIMARY KEY AUTO_INCREMENT,LEAVE_TYPE ENUM('EL'),START_DATE DATE,END_DATE DATE,NO_OF_DAYS INT,LEAVE_STATUS ENUM('PENDING','APPROVED','DENIED'),LEAVE_REASON TEXT,LEAVE_APPLIED_ON DATE,MANAGER_COMMENTS TEXT,EMP_ID INT);

ALTER TABLE LEAVE_DETAILS ADD CONSTRAINT SK FOREIGN KEY(EMP_ID) REFERENCES EMPLOYEE (EMP_ID);
