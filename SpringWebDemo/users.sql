/* 사용자 */
CREATE TABLE scott.Users (
	userid VARCHAR2(12) NOT NULL, /* 아이디 */
	passwd VARCHAR2(12) NOT NULL, /* 비밀번호 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	age NUMBER(2) NOT NULL, /* 나이 */
	gender CHAR(1) NOT NULL /* 성별 */
);

COMMENT ON TABLE scott.Users IS '사용자';

COMMENT ON COLUMN scott.Users.userid IS '아이디';

COMMENT ON COLUMN scott.Users.passwd IS '비밀번호';

COMMENT ON COLUMN scott.Users.name IS '이름';

COMMENT ON COLUMN scott.Users.age IS '나이';

COMMENT ON COLUMN scott.Users.gender IS '성별';

CREATE UNIQUE INDEX scott.PK_Users
	ON scott.Users (
		userid ASC
	);

ALTER TABLE scott.Users
	ADD
		CONSTRAINT PK_Users
		PRIMARY KEY (
			userid
		);