Create table PROPERTIES(
  id NUMBER not NULL,
  key VARCHAR2(50) not null,
  value VARCHAR2(50),
  CONSTRAINT pk_id PRIMARY KEY(id)
);

CREATE SEQUENCE property_sequence;