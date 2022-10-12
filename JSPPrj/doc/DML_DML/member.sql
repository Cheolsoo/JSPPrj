--------------------------------------------------------
--  파일이 생성됨 - 수요일-10월-12-2022   
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
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "NEWLEC" ;
REM INSERTING into NEWLEC.MEMBER
SET DEFINE OFF;
