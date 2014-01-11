-- Database: estore
/*
DROP DATABASE estore;

CREATE DATABASE estore
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

*/
-- Table: "Posts"

DROP TABLE "Posts";

CREATE TABLE "Posts"
(
  "Id" serial NOT NULL,
  "Date" date,
  "Text" text,
  CONSTRAINT "PostsPK" PRIMARY KEY ("Id")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Posts"
  OWNER TO postgres;

insert into "Posts" ("Date", "Text") values ('2014-01-01', 'This is the first our post!!!!');
insert into "Posts" ("Date", "Text") values ('2014-01-10', 'This is the second our post!!!!Stay connected!');