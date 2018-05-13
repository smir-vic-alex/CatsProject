CREATE TABLE SETTINGS(
  ID NUMBER NOT NULL,
  KEY VARCHAR2(150) NOT NULL,
  VALUE VARCHAR2(150),
  CONSTRAINT PK_ID PRIMARY KEY(ID)
);

CREATE SEQUENCE PROPERTY_SEQUENCE;

CREATE TABLE PASSWORDS(
  ID NUMBER NOT NULL,
  HASH VARCHAR2(32),
  LOGIN_ID NUMBER NOT NULL ,
  CONSTRAINT PAS_PK_ID PRIMARY KEY (ID),
  CONSTRAINT LOGIN_ID_FK FOREIGN KEY (LOGIN_ID) REFERENCES LOGINS(ID)
);
CREATE SEQUENCE PASSWORDS_SEQ;

CREATE TABLE LOGINS(
  ID NUMBER NOT NULL,
  LOGIN VARCHAR2(32),
  CONSTRAINT LOG_PK_ID PRIMARY KEY (ID)
);
CREATE SEQUENCE LOGINS_SEQ;

CREATE TABLE USERS(
  ID NUMBER NOT NULL ,
  LOGIN_ID INTEGER NOT NULL,
  CONSTRAINT USER_PK_ID PRIMARY KEY (ID),
  CONSTRAINT LOGIN_FK FOREIGN KEY (LOGIN_ID) REFERENCES LOGINS (ID),
);
CREATE SEQUENCE USERS_ID_SEQ;
CREATE INDEX  "LOGIN_INDEX" ON USERS (LOGIN_ID);

CREATE TABLE  NETWORKS(
  ID NUMBER NOT NULL,
  TYPE VARCHAR2(50),
  USER_ID NUMBER NOT NULL,
  VK_ACCESS_TOKEN VARCHAR2(200),
  VK_USER_ID NUMBER,
  CONSTRAINT NET_PK_ID PRIMARY KEY (ID),
  CONSTRAINT NET_USERS_ID_FK FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);
CREATE SEQUENCE NETWORKS_ID_SEQ;

CREATE TABLE ACCESSES(
  ID NUMBER NOT NULL,
  TYPE VARCHAR2(32),
  CONSTRAINT OPER_PK_ID PRIMARY KEY (ID)
);
CREATE SEQUENCE OPERATIONS_SEQ;

CREATE TABLE USERS_OPERATIONS(
  USER_ID NUMBER NOT NULL ,
  OPERATION_ID NUMBER NOT NULL,
  CONSTRAINT FK_USER_ID_U_O FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
  CONSTRAINT FK_OPER_ID_U_O FOREIGN KEY (OPERATION_ID) REFERENCES OPERATIONS(ID)
)

CREATE TABLE USERS_TOKENS(
  USER_ID NUMBER NOT NULL ,
  CODE VARCHAR(100),
  TOKEN VARCHAR(100),
  CONSTRAINT FK_USER_ID_U_T FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
);

CREATE SEQUENCE TOKENS_SEQ;
ALTER TABLE USERS_TOKENS
  ADD APP VARCHAR(10);

ALTER TABLE USERS_TOKENS
  ADD ID NUMBER NOT NULL ;

alter table
   USERS_TOKENS
add constraint
   USR_TKN_PK_ID PRIMARY KEY (ID)