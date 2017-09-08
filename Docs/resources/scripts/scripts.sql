CREATE TABLE PROPERTIES(
  ID NUMBER NOT NULL,
  KEY VARCHAR2(150) NOT NULL,
  VALUE VARCHAR2(150),
  CONSTRAINT PK_ID PRIMARY KEY(ID)
);

CREATE SEQUENCE PROPERTY_SEQUENCE;

CREATE TABLE PASSWORDS(
  ID NUMBER NOT NULL,
  HASH VARCHAR2(32),
  CONSTRAINT PAS_PK_ID PRIMARY KEY (ID)
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
  NAME VARCHAR2(100),
  SUR_NAME VARCHAR2(100),
  PATR_NAME VARCHAR2(100),
  EMAIL VARCHAR2(100),
  NETWORKS_ID INTEGER,
  PASSWORD_ID INTEGER NOT NULL,
  LOGIN_ID INTEGER NOT NULL,
  OPERATIONS_ID INTEGER,
  CONSTRAINT USER_PK_ID PRIMARY KEY (ID),
  CONSTRAINT LOGIN_FK FOREIGN KEY (LOGIN_ID) REFERENCES LOGINS (ID),
  CONSTRAINT PASSWORD_FK FOREIGN KEY (PASSWORD_ID) REFERENCES PASSWORDS (ID)

);
CREATE SEQUENCE USERS_ID_SEQ;
CREATE INDEX  "NETWORK_INDEX" ON USERS (NETWORKS_ID);
CREATE INDEX  "PASSWORD_INDEX" ON USERS (PASSWORD_ID);
CREATE INDEX  "LOGIN_INDEX" ON USERS (LOGIN_ID);
CREATE INDEX  "OPERATION_INDEX" ON USERS (OPERATIONS_ID);


CREATE TABLE  NETWORKS(
  ID NUMBER NOT NULL ,
  USER_ID INTEGER NOT NULL,
  TYPE VARCHAR2(50),
  VK_ACCESS_TOKEN VARCHAR2(200),
  LIST_INDEX INTEGER,
  CONSTRAINT NET_PK_ID PRIMARY KEY (ID),
  CONSTRAINT FK_NET FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);
CREATE INDEX "NET_USR_ID_INDEX" ON NETWORKS (USER_ID);
CREATE SEQUENCE NETWORKS_ID_SEQ;


CREATE TABLE OPERATIONS(
  ID NUMBER NOT NULL,
  TYPE VARCHAR2(32),
  LIST_INDEX INTEGER,
  USER_ID INTEGER NOT NULL,
  CONSTRAINT OPER_PK_ID PRIMARY KEY (ID),
  CONSTRAINT FK_NET FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);
CREATE SEQUENCE OPERATIONS_SEQ;
CREATE INDEX "OPER_USR_ID_INDEX" ON OPERATIONS (USER_ID);

