/* ����� */
CREATE TABLE scott.Users (
	userid VARCHAR2(12) NOT NULL, /* ���̵� */
	passwd VARCHAR2(12) NOT NULL, /* ��й�ȣ */
	name VARCHAR2(20) NOT NULL, /* �̸� */
	age NUMBER(2) NOT NULL, /* ���� */
	gender CHAR(1) NOT NULL /* ���� */
);

COMMENT ON TABLE scott.Users IS '�����';

COMMENT ON COLUMN scott.Users.userid IS '���̵�';

COMMENT ON COLUMN scott.Users.passwd IS '��й�ȣ';

COMMENT ON COLUMN scott.Users.name IS '�̸�';

COMMENT ON COLUMN scott.Users.age IS '����';

COMMENT ON COLUMN scott.Users.gender IS '����';

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