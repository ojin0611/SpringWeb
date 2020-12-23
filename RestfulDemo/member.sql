CREATE TABLE Member
(
  name      VARCHAR2(20)   NOT NULL,
  userid    VARCHAR2(12)   PRIMARY KEY,
  gender    VARCHAR2(10)   NOT NULL,
  city      VARCHAR2(20)   NOT NULL
);

INSERT INTO Member
VALUES('한지민', 'jimin', '여성', '서울');
INSERT INTO Member
VALUES('박지민', 'javaexpert', '남성', '부산');
INSERT INTO Member
VALUES('김지민', 'javasoft', '여성', '인천');
COMMIT;