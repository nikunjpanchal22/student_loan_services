DROP TABLE GUARANTOR
/
CREATE TABLE GUARANTOR (
  GURANTOR_ID NUMBER(10) GENERATED BY DEFAULT AS IDENTITY,
  APPLICANT_ID NUMBER(10),
  APPLICATION_ID NUMBER(10),
  NAME VARCHAR2(255),
  RELATIONSHIP VARCHAR2(255),
  OCCUPATION VARCHAR2(255),
  ANNUAL_INCOME NUMBER,
  ADDRESS VARCHAR2(255),
  UIN_NO VARCHAR2(255),
  MONTHLY_EXPENSE NUMBER,
  PRIMARY KEY (GURANTOR_ID, APPLICANT_ID, APPLICATION_ID),
  FOREIGN KEY (APPLICATION_ID) REFERENCES LOAN_APPLICATION(APPLICATION_ID),
  FOREIGN KEY (APPLICANT_ID) REFERENCES APPLICANT(APPLICANT_ID)
)
/