Create table PROPERTIES(
  id NUMBER not NULL,
  key VARCHAR2(150) not null,
  value VARCHAR2(150),
  CONSTRAINT pk_id PRIMARY KEY(id)
);

CREATE SEQUENCE property_sequence;

Create TABLE  NETWORKS(
  id NUMBER NOT NULL ,
  type VARCHAR2(50),
  vk_access_token VARCHAR2(200),
  CONSTRAINT pk_id PRIMARY KEY (id)
);
create SEQUENCE networks_id_seq;

CREATE TABLE PASSWORDS(
  id NUMBER NOT NULL,
  hash VARCHAR2(32),
  CONSTRAINT pk_id PRIMARY KEY (id)
);
create SEQUENCE passwords_seq;

CREATE TABLE LOGINS(
  id NUMBER NOT NULL,
  login VARCHAR2(32),
  CONSTRAINT pk_id PRIMARY KEY (id)
);
CREATE SEQUENCE logins_seq;

CREATE TABLE OPERATIONS(
  id NUMBER NOT NULL,
  type VARCHAR2(32),
  CONSTRAINT pk_id PRIMARY KEY (id)
);
CREATE SEQUENCE operations_seq;

CREATE TABLE USERS_NETWORKS(
  id NUMBER NOT NULL ,
  id_network NUMBER NOT NULL,
  CONSTRAINT pk_id PRIMARY KEY (id),
  FOREIGN KEY (id_network) REFERENCES NETWORKS(id)
);
create SEQUENCE users_net_id_seq;

Create table USERS(
  id number not NULL ,
  name VARCHAR2(100),
  sur_name VARCHAR2(100),
  patr_name VARCHAR2(100),
  email VARCHAR2(100),
  networks_id number,
  password_id NUMBER,
  login_id NUMBER,
  operations_id NUMBER,
  CONSTRAINT pk_id PRIMARY KEY (id),
  FOREIGN KEY (networks_id) REFERENCES USERS_NETWORKS(id),
  FOREIGN KEY (password_id) REFERENCES PASSWORDS(id),
  FOREIGN KEY (login_id) REFERENCES LOGINS(id),
  FOREIGN KEY (operations_id) REFERENCES OPERATIONS(id)
);
create SEQUENCE users_id_seq;