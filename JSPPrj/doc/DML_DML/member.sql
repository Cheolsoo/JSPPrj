--------------------------------------------------------
--  파일이 생성됨 - 화요일-10월-18-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "NEWLEC"."MEMBER" 
   (	"ID" NVARCHAR2(50), 
	"PWD" NVARCHAR2(50), 
	"NAME" NVARCHAR2(50), 
	"GENDER" NCHAR(2), 
	"BIRTHDAY" CHAR(10 BYTE), 
	"PHONE" CHAR(13 BYTE), 
	"REGDATE" DATE, 
	"EMAIL" NVARCHAR2(200)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "NEWLEC" ;
REM INSERTING into NEWLEC.MEMBER
SET DEFINE OFF;
Insert into NEWLEC.MEMBER (ID,PWD,NAME,GENDER,BIRTHDAY,PHONE,REGDATE,EMAIL) values ('newlec','today','newlec','남 ','1972.12.18','010-2823-3414',null,null);
