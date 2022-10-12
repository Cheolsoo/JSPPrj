--------------------------------------------------------
--  파일이 생성됨 - 수요일-10월-12-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COMMENTS
--------------------------------------------------------

  CREATE TABLE "NEWLEC"."COMMENTS" 
   (	"ID" NUMBER, 
	"CONTENT" NVARCHAR2(2000), 
	"REGDATE" TIMESTAMP (6), 
	"WRITER_ID" NVARCHAR2(50), 
	"NOTICE_ID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "NEWLEC" ;
REM INSERTING into NEWLEC.COMMENTS
SET DEFINE OFF;
