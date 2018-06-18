   --21-08-2015 CHANGES FOR AUTOPAYMET 
   UPDATE PG_ACCOUNT SET AUTO_TRANSFER_DAY=null WHERE 1=1;
   ALTER TABLE PG_ACCOUNT MODIFY  AUTO_TRANSFER_DAY  VARCHAR2(80 BYTE);
   ALTER TABLE PG_ACCOUNT_HISTORY MODIFY  AUTO_TRANSFER_DAY  VARCHAR2(80 BYTE);
   
DELETE FROM PG_STATE;
DELETE FROM PG_COUNTRY;

INSERT INTO PG_COUNTRY(ID, NAME) VALUES (1,'USA');

Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (1,'Alaska','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (2,'Alabama','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (3,'Arizona ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (4,'Arkansas ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (5,'California  ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (6,'Colorado ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (7,'Connecticut ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (8,'Delaware ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (9,'Florida ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (10,'Georgia ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (11,'Hawaii ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (12,'Idaho ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (13,'Illinois ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (14,'Indiana ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (15,'Iowa ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (16,'Kansas ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (17,'Kentucky ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (18,'Louisiana ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (19,'Maine ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (20,'Maryland ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (21,'Massachusetts','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (22,'Michigan ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (23,'Minnesota ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (24,'Mississippi ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (25,'Missouri ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (26,'Montana ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (27,'Nebraska ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (28,'Nevada ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (29,'New Hampshire','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (30,'New Jersey   ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (31,'New Mexico ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (32,'New York ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (33,'North Carolina','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (34,'North Dakota ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (35,'Ohio ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (36,'Oklahoma ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (37,'Oregon       ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (38,'Pennsylvania ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (39,'Rhode Island ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (40,'South Carolina','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (41,'South Dakota ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (42,'Tennessee ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (43,'Texas ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (44,'Utah ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (45,'Vermont ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (46,'Virginia ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (47,'Washington   ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (48,'West Virginia','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (49,'Wisconsin ','Active',1);
Insert into PG_STATE (ID,NAME,STATUS,COUNTRY_ID) values (50,'Wyoming ','Active',1);


Update pg_account SET entity_id=1 where id=1;

commit;

-- UPDATED SCRIPT TILL THIS DEPLOYED ON PRODUCTION (28/08/2015) 

-- 
-- 01/09/2015
--------------------------------------------------------
--  DDL for Table PG_PARAMS
--------------------------------------------------------
CREATE TABLE "PG_PARAMS" 
   (
   	"ID"      NUMBER(4,0) PRIMARY KEY,
   	"PARAM_NAME" VARCHAR2(100), 
	"PARAM_VALUE" VARCHAR2(1000),
	"STATUS"      NUMBER(1,0) DEFAULT 1
   );
   
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (1, 'LITLE_USER_DEMO', 'Chatak');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (2, 'LITLE_PASS_DEMO', 'chataK$321');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (3, 'LITLE_URL_DEMO', 'https://www.testlitle.com/sandbox/communicator/online');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (4, 'LITLE_MID_DEMO', '93214');

INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (5, 'LITLE_USER_PRELIVE', 'RAPIDS');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (6, 'LITLE_PASS_PRELIVE', 'certYv4d');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (7, 'LITLE_URL_PRELIVE', 'https://prelive.litle.com/vap/communicator/online');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (8, 'LITLE_MID_PRELIVE', '7103428');

INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (9, 'LITLE_USER_LIVE', 'RAPIDS');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (10, 'LITLE_PASS_LIVE', 'Yv4dj3x2');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (11, 'LITLE_URL_LIVE', 'https://payments.litle.com/vap/communicator/online');


ALTER TABLE PG_MERCHANT ADD LITLE_MID VARCHAR2(50 BYTE);

ALTER TABLE PG_ONLINE_TXN_LOG ADD APP_MODE VARCHAR2(50 BYTE);

ALTER TABLE PG_TRANSACTION ADD TXN_MODE VARCHAR2(50 BYTE);

ALTER TABLE PG_SWITCH_TRANSACTION ADD TXN_MODE VARCHAR2(50 BYTE);

--20150803 ALTER SCRIPT FOR PG_TRANSACTION  ACQ_CHANNEL 
ALTER TABLE PG_TRANSACTION MODIFY ACQ_CHANNEL VARCHAR2(30) DEFAULT 'web';

-- Need to change this for Production, this should be executed only once.
UPDATE PG_MERCHANT SET LITLE_MID='7103428' WHERE 1=1;

INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (13, 'MAG_TEK_KEY', '796d6b3057566c304c31444664643674344d7030796b47596b6868657166776b55596255777057676c744b6d624246504641652f64513d3d');

--20150915 Added table for user access logs 

CREATE  TABLE PG_USER_ACTIVITY_LOG
  (
    ACTIVITY_LOG_ID  NUMBER(20,0) NOT NULL,
    USER_ID          VARCHAR2(255) DEFAULT NULL,
    LOGIN_SESSION_ID VARCHAR2(255) DEFAULT NULL,
    AUDIT_SECTION    VARCHAR2(255) DEFAULT NULL,
    AUDIT_EVENT      VARCHAR2(255) DEFAULT NULL,
    AUDIT_SERVICE    VARCHAR2(255) DEFAULT NULL,
    REQUEST_DATA     VARCHAR2(4000) DEFAULT NULL,
    DATA_CHANGE      VARCHAR2(255) DEFAULT NULL,
    STATUS           VARCHAR2(500) DEFAULT NULL,
    DESCRIPTION      VARCHAR2(500) DEFAULT NULL,
    IP_ADDRESS       VARCHAR2(500) DEFAULT NULL,
    ACTIVITY_DATE    TIMESTAMP NOT NULL
  );
ALTER TABLE PG_USER_ACTIVITY_LOG ADD CONSTRAINT PG_USER_ACTIVITY_LOG_PK PRIMARY KEY ( ACTIVITY_LOG_ID);

CREATE SEQUENCE "SEQ_PG_USER_ACTIVITY_LOG" MINVALUE 1 MAXVALUE
  99999999999999999999 INCREMENT BY 1 START WITH 10 NOCACHE NOORDER NOCYCLE ;
  
  --20150803 ALTER SCRIPT FOR PG_LEGAL_ENTITY  ANNUAL_CARD_SALE ,PG_MERCHANT_BANK NAME_ON_ACCOUNT
  
  ALTER TABLE PG_LEGAL_ENTITY MODIFY ANNUAL_CARD_SALE NUMBER(14,0);
  
  ALTER TABLE PG_MERCHANT_BANK MODIFY NAME_ON_ACCOUNT VARCHAR2(150 BYTE);
  
  --20150921 DDL FOR PG_ACCOUNT_FEE_LOG AND SEQ_PG_ACCOUNT_FEE_LOG TO LOG FEE DETAILS DURING TRANSACTION STAGES
  
  CREATE
  TABLE "PG_ACCOUNT_FEE_LOG"
  (
    "ID"                   NUMBER(10,0) PRIMARY KEY,
    "ENTITY_ID"            VARCHAR2(50 BYTE) NOT NULL ENABLE,
    "ENTITY_TYPE"          VARCHAR2(50 BYTE) NOT NULL ENABLE,
    "ACCOUNT_DESC"         VARCHAR2(100 BYTE),
    "CATEGORY"             VARCHAR2(100 BYTE),
    "CURRENCY"             VARCHAR2(20 BYTE) DEFAULT 'USD',
    "STATUS"               VARCHAR2(20 BYTE),
    "CREATED_DATE"         TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP,
    "UPDATED_DATE"         TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP,
    "ACCOUNT_NUM"          NUMBER(20,0),
    "PAYMENT_METHOD"       VARCHAR2(20 BYTE),
    "TRANSACTION_ID"       NUMBER(12,0),
    "PARENT_ENTITY_ID"     VARCHAR2(50 BYTE),
    "MERCHANT_FEE"         NUMBER(20,0) DEFAULT 0,
    "CHATAK_FEE"           NUMBER(20,0) DEFAULT 0,
    "TXN_AMOUNT"           NUMBER(20,0) DEFAULT 0
  );
CREATE SEQUENCE "SEQ_PG_ACCOUNT_FEE_LOG" MINVALUE 1 MAXVALUE 9999999999
  INCREMENT BY 1 START WITH 47 NOCACHE NOORDER NOCYCLE ;
  
  --  20150923 PRODUCTION PROCESSOR VALUES INSERT  
TRUNCATE TABLE PG_SWITCH;

INSERT INTO PG_SWITCH (ID,SWITCH_NAME,SWITCH_TYPE,SWITCH_IP,SWITCH_PORT,STATUS,PRIORITY,CREATED_BY,UPDATED_BY) VALUES (1,'LITLE','SOCKET','192.168.1.215','22403',0,1,1,1);


 --  20150923 PRODUCTION PG_MERCHANT APPLICATION MODE UPDATE

UPDATE PG_MERCHANT SET APPLICATION_MODE='LIVE' WHERE APPLICATION_MODE='live';


--  20151012 ALTER SCRIPT FOR PG_MERCHANT CHANGES FOR  MERCHANT ONBOARDING

ALTER TABLE PG_MERCHANT ADD LOOKING_FOR VARCHAR2(500);
ALTER TABLE PG_MERCHANT ADD BUSINESS_TYPE VARCHAR2(100);

--20151026 PG_TRANSACTION ALTER SCRIPT TO MAKE MERCHANT_CODE VARCHAR
ALTER TABLE PG_TRANSACTION ADD (MERCHANT_ID_new VARCHAR2(200) );
UPDATE
  PG_TRANSACTION
SET
  MERCHANT_ID_new = MERCHANT_ID;
ALTER TABLE PG_TRANSACTION
DROP
  COLUMN MERCHANT_ID;
ALTER TABLE PG_TRANSACTION RENAME column MERCHANT_ID_new TO MERCHANT_ID;


-- 20151026 PG_TRANSFERS ALTER SCRIPT TO MAKE MERCHANT_CODE VARCHAR
ALTER TABLE PG_TRANSFERS ADD (MERCHANT_ID_new VARCHAR2(200) );
UPDATE
  PG_TRANSFERS
SET
  MERCHANT_ID_new = MERCHANT_ID;
ALTER TABLE PG_TRANSFERS
DROP
  COLUMN MERCHANT_ID;
ALTER TABLE PG_TRANSFERS RENAME column MERCHANT_ID_new TO MERCHANT_ID;

-- PG_LEGAL_ENTITY ALTER SCRIPT TO MAKE MERCHANT_CODE VARCHAR
ALTER TABLE PG_LEGAL_ENTITY ADD (MERCHANT_ID_new VARCHAR2(200) );
UPDATE
  PG_LEGAL_ENTITY
SET
  MERCHANT_ID_new = MERCHANT_ID;
ALTER TABLE PG_LEGAL_ENTITY
DROP
  COLUMN MERCHANT_ID;
ALTER TABLE PG_LEGAL_ENTITY RENAME column MERCHANT_ID_new TO MERCHANT_ID;


-- 20151026 PG_LEGAL_ENTITY ALTER SCRIPT TO MAKE MERCHANT_CODE CHANGES FOR EXISTING DB

UPDATE PG_TRANSACTION SET MERCHANT_ID='063626195936645' WHERE MERCHANT_ID='63626195936645';
UPDATE PG_TRANSFERS SET MERCHANT_ID='063626195936645' WHERE MERCHANT_ID='63626195936645';
UPDATE PG_LEGAL_ENTITY SET MERCHANT_ID='063626195936645' WHERE MERCHANT_ID='63626195936645';

-- 20151028 PG_TRANSACTION ALTER SCRIPT TO MAKE LITLE EFT transfers
ALTER TABLE PG_TRANSACTION ADD (EFT_STATUS VARCHAR2(50) );
ALTER TABLE PG_TRANSACTION ADD (EFT_ID VARCHAR2(50) );

-- 20151109 PG_MERCHANT & PG_ACCOUNT_FEE_LOG ALTER SCRIPT TO ADD AGENT DETAILS FOR VERTUAL ACCOUNTS

ALTER TABLE PG_MERCHANT ADD AGENT_ID VARCHAR2(50);
ALTER TABLE PG_MERCHANT ADD ISSUANCE_PARTNER_ID VARCHAR2(50);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD FEE_POST_STATUS NUMBER(1);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD PARTNER_ACCOUNT_NUM VARCHAR2(50);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD AGENT_ACCOUNT_NUM VARCHAR2(50);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD ISSUANCE_MESSAGE VARCHAR2(100);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD ISSUANCE_FEE_TXN_ID VARCHAR2(25);
ALTER TABLE PG_ACCOUNT_FEE_LOG ADD FEE_TXN_DATE TIMESTAMP;

--20151130 FEE_SERVICE BASE URL ON APPLICATION MODE

INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (14, 'FEE_SERVICE_DEMO', 'http://192.168.2.105:9010/prepaidservices');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (15, 'FEE_SERVICE_PRELIVE', 'http://192.168.2.105:9010/prepaidservices');
INSERT INTO PG_PARAMS (ID, PARAM_NAME, PARAM_VALUE) values (16, 'FEE_SERVICE_LIVE', 'http://192.168.2.105:9010/prepaidservices');

ALTER TABLE PG_MERCHANT ADD PROGRAM_MANAGER_ID VARCHAR2(50);

--20151216 PG_MERCHANT_BANK ALTER SCRIPT TO MAKE PIN VARCHAR
ALTER TABLE PG_MERCHANT_BANK ADD (PIN_new VARCHAR2(10) );
UPDATE
  PG_MERCHANT_BANK
SET
  PIN_new = PIN;
ALTER TABLE PG_MERCHANT_BANK
DROP
  COLUMN PIN;
ALTER TABLE PG_MERCHANT_BANK RENAME column PIN_new TO PIN;

--20151216 PG_LIGAL_ENTITY ALTER SCRIPT TO MAKE PIN VARCHAR
ALTER TABLE PG_LEGAL_ENTITY ADD (PIN_new VARCHAR2(10) );
UPDATE
  PG_LEGAL_ENTITY
SET
  PIN_new = PIN;
ALTER TABLE PG_LEGAL_ENTITY
DROP
  COLUMN PIN;
ALTER TABLE PG_LEGAL_ENTITY RENAME column PIN_new TO PIN;

--20160107 PG_TRANSACTION ALTER SCRIPT TO ADD EFT_MODE
 ALTER TABLE PG_TRANSACTION ADD EFT_MODE VARCHAR2(50);
 
 commit;
 
 --DB_Alter_Script_Sprint_13.sql
-- ----------------------------------------------------------------------------------------------------------------
-- CA -59 CHANGES FOR VIEW/PROCESS/EXECUTE/VOID/REFUND ACCESS -20160122
-- ----------------------------------------------------------------------------------------------------------------
ALTER TABLE PG_MERCHANT_USERS ADD (
	FIRST_NAME VARCHAR2(50),LAST_NAME VARCHAR2(50),PHONE VARCHAR2(20),USER_ROLE_ID NUMBER(5,0) DEFAULT 2 NOT NULL, EMAIL VARCHAR2(100 BYTE), PG_MERCHANT_ID VARCHAR2(200 BYTE)
);

ALTER TABLE PG_SUB_FEATURES MODIFY FEATURE_NAME VARCHAR2(50 BYTE);

insert into PG_SUB_FEATURES values(21,3,'View Sub-Merchant Transactions','viewSubMerchantTransactions');
insert into PG_SUB_FEATURES values(22,3,'Process Sub-Merchant Transactions','processSubMerchantTransactions');
insert into PG_SUB_FEATURES values(23,3,'Execute Sub-Merchant Transactions','executeSubMerchantTransactions');
insert into PG_SUB_FEATURES values(24,3,'Refund Sub-Merchant Transactions','refundSubMerchantTransactions');
insert into PG_SUB_FEATURES values(25,3,'Void Sub-Merchant Transactions','voidSubMerchantTransactions');

commit;
--DB_Alter_Script_Sprint_14.sql
-----------------------------------------------------
--  DDL for Sequence SEQ_PG_TOKEN_CUSTOMER
--------------------------------------------------------
CREATE SEQUENCE SEQ_PG_TOKEN_CUSTOMER MINVALUE 1 MAXVALUE 999999999999 INCREMENT BY 1 START WITH 10 NOCACHE NOORDER NOCYCLE ;
--------------------------------------------------------
--  DDL for Table PG_TOKEN_CUSTOMER
--------------------------------------------------------
    CREATE TABLE PG_TOKEN_CUSTOMER
    (
      PG_TOKEN_CUSTOMER_ID NUMBER(20,0) NOT NULL ENABLE,
      USER_ID        	   VARCHAR2(50) NOT NULL ENABLE,
      PASSWORD  	   VARCHAR2(50 BYTE) NOT NULL ENABLE,
      CREATED_DATE         TIMESTAMP (6) NOT NULL,
      UPDATED_DATE         TIMESTAMP (6)
    );
  ALTER TABLE PG_TOKEN_CUSTOMER ADD CONSTRAINT PG_TOKEN_CUSTOMER_PK PRIMARY KEY (PG_TOKEN_CUSTOMER_ID);
  ALTER TABLE PG_TOKEN_CUSTOMER ADD CONSTRAINT USER_ID_UK UNIQUE (USER_ID);

--------------------------------------------------------
--  ALTER SCRIPT for Table PG_CARD_TOKEN_DETAILS
--------------------------------------------------------
 ALTER TABLE PG_CARD_TOKEN_DETAILS ADD  PG_TOKEN_CUSTOMER_ID  NUMBER(20,0);

 ALTER TABLE PG_CARD_TOKEN_DETAILS ADD  PAN  VARCHAR2(500);
 ALTER TABLE PG_CARD_TOKEN_DETAILS ADD  EXPIRY_DATE  VARCHAR2(500);
 ALTER TABLE PG_CARD_TOKEN_DETAILS ADD  CARD_HOLDER_NAME  VARCHAR2(200);
 
 COMMIT;
 
 --DB_Alter_Script_Sprint_15.sql
 
 --CA-66 Changes Starts

--------------------------------------------------------
--  Alter script for PG_FEE_PROGRAM
--------------------------------------------------------
ALTER TABLE  PG_FEE_PROGRAM ADD PG_OTHER_FEE_VALUE_ID NUMBER(20,0);
--------------------------------------------------------
--  DDL for Sequence SEQ_PG_ACQUIRER_FEE_VALUE
--------------------------------------------------------

CREATE SEQUENCE  "SEQ_PG_ACQUIRER_FEE_VALUE"  MINVALUE 1 MAXVALUE 99999999999999999999 INCREMENT BY 1 START WITH 10 NOCACHE  NOORDER  NOCYCLE ;

--------------------------------------------------------
--  DDL for PG_ACQUIRER_FEE_VALUE
--------------------------------------------------------

CREATE TABLE PG_ACQUIRER_FEE_VALUE 
(	
	PG_ACQUIRER_FEE_VALUE_ID 	NUMBER(20,0) NOT NULL ENABLE,
	CARD_TYPE              		VARCHAR2(4),
	FEE_PROGRAM_ID 				NUMBER(20,0), 
	FEE_FLAT_VALUE 				NUMBER(20,0), 
	FEE_PERCENTAGE_ONLY 		NUMBER(20,2),
	ACCOUNT_TYPE				VARCHAR2(20),
	ACCOUNT_NUMBER 				VARCHAR2(200),
	CREATED_BY    				VARCHAR2(20) NOT NULL,
	UPDATED_BY              	VARCHAR2(20),
	CREATED_DATE 				TIMESTAMP (6)	NOT NULL, 
	UPDATED_DATE 				TIMESTAMP (6),
	STATUS 						VARCHAR2(20)

) ;


ALTER TABLE PG_ACQUIRER_FEE_VALUE ADD CONSTRAINT PG_ACQUIRER_FEE_VALUE_PK PRIMARY KEY (PG_ACQUIRER_FEE_VALUE_ID);
ALTER TABLE PG_ACQUIRER_FEE_VALUE ADD CONSTRAINT PG_ACQUIRER_FEE_VALUE_PG_F_FK1 FOREIGN KEY (FEE_PROGRAM_ID) REFERENCES PG_FEE_PROGRAM (FEE_PROGRAM_ID) ENABLE;

--------------------------------------------------------
--  DDL for Sequence SEQ_PG_ACQUIRER_FEE_VALUE
--------------------------------------------------------
CREATE SEQUENCE  "SEQ_PG_OTHER_FEE_VALUE"  MINVALUE 1 MAXVALUE 99999999999999999999 INCREMENT BY 1 START WITH 10 NOCACHE  NOORDER  NOCYCLE ;

--------------------------------------------------------
--  DDL for PG_OTHER_FEE_VALUE
--------------------------------------------------------

CREATE TABLE PG_OTHER_FEE_VALUE 
(	
	PG_OTHER_FEE_VALUE_ID 			NUMBER(20,0) NOT NULL ENABLE,
  	SETUP_FEE	 					NUMBER(20,0), 
	SETTLEMENT_FEE 					NUMBER(20,0),
	CHARGE_BACK_FEE					NUMBER(20,0),
	CHARGE_FREQUENCY  				VARCHAR2(20),
	CREATED_BY    					VARCHAR2(20) NOT NULL,
	UPDATED_BY              		VARCHAR2(20),
	CREATED_DATE 					TIMESTAMP (6)	NOT NULL, 
	UPDATED_DATE 					TIMESTAMP (6)
	) ;

ALTER TABLE PG_OTHER_FEE_VALUE ADD CONSTRAINT PG_OTHER_FEE_VALUE_PK PRIMARY KEY (PG_OTHER_FEE_VALUE_ID);

--------------------------------------------------------
--  Alter script for PG_ACCOUNT_FEE_LOG
--------------------------------------------------------

ALTER TABLE PG_ACCOUNT_FEE_LOG  ADD SPECIFIC_ACCOUNT_NUM 	VARCHAR2(50);

--CA-66 Changes Ends
COMMIT;