--계정 만들기
ALTER SESSION SET "_ORACLE_SCRIPT"=true;   --단, Oracle 12c 이상버전만

CREATE USER bbs IDENTIFIED BY bbs
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

--단, Oracle 12c 이상버전만
ALTER USER bbs
DEFAULT TABLESPACE USERS
QUOTA UNLIMITED ON USERS;

GRANT resource, connect TO bbs;
conn bbs/bbs

--Bbs Table 생성하기
CREATE TABLE Bbs
(
  idx NUMBER(4),
  writer VARCHAR2(50) NOT NULL,
  title VARCHAR2(100) NOT NULL,
  contents VARCHAR2(2000) NOT NULL,
  email VARCHAR2(200),
  readnum NUMBER(4) NOT NULL,
  writeday DATE NOT NULL,
  CONSTRAINT bbs_idx_pk PRIMARY KEY(idx)
)

--게시판 번호 시퀀스 생성하기
CREATE SEQUENCE bbs_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 9999
  NOCYCLE;

--게시판 전체 목록 가져오기
CREATE OR REPLACE PROCEDURE sp_bbs_select_all
(
  bbs_record OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN bbs_record FOR
    SELECT idx, writer, email, title, writeday, readnum
    FROM BBS
    ORDER BY idx DESC;
END;

--게시판 글쓰기
CREATE OR REPLACE PROCEDURE sp_bbs_insert
(
  v_writer IN bbs.writer%TYPE,
  v_email IN bbs.email%TYPE,
  v_title IN bbs.title%TYPE,
  v_contents IN bbs.contents%TYPE
)
IS
BEGIN
    INSERT INTO BBS(idx, writer, title, contents, email, readnum, writeday)
    VALUES(bbs_seq.NEXTVAL, v_writer, v_title, v_contents, v_email, 0, SYSDATE);
END;

--글 번호로 한 개의 bbs 가져오기, 조회수 증가하기
CREATE OR REPLACE PROCEDURE sp_bbs_select
(
    v_idx     IN      bbs.idx%TYPE,
    bbs_record      OUT      SYS_REFCURSOR
)
AS
BEGIN
    OPEN bbs_record FOR
    SELECT idx, writer, email, title, writeday, readnum, contents
    FROM BBS
    WHERE idx = v_idx;
    
    UPDATE BBS SET readnum = readnum + 1
    WHERE idx = v_idx;
END;