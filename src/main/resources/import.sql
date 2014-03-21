--drop table Books;
--drop table Series;
--drop table Genres;
--drop table Authors;
--drop table Comments;
--drop table Posts;
--drop table Blogs;
--drop table Users;

insert into Genres (Title) values ('Poetry');
insert into Genres (Title) values ('Arts & Design');
insert into Genres (Title) values ('History');
insert into Genres (Title) values ('Philosofy');
insert into Genres (Title) values ('Fiction');
insert into Genres (Title) values ('Fantasy');
insert into Genres (Title) values ('Computer Science');
insert into Genres (Title) values ('Kid''s reading');
insert into Genres (Title) values ('Science & Technology');

insert into Authors (Name) values (U&'\0420\0443\0441\0441\0438\043d\043e\0432\0438\0447 \041c.');
insert into Authors (Name) values (U&'\0414\0436. \0420\0438\0445\0442\0435\0440');
insert into Authors (Name) values (U&'\0422\0430\043d\0435\043d\0431\0430\0443\043c \042d. \0421.');
insert into Authors (Name) values (U&'\041b\0430\0444\043e\0440\0435 \0420.');
insert into Authors (Name) values (U&'\041f\0430\0442\0442\0435\0440\0441\043e\043d \0414.');
insert into Authors (Name) values (U&'\0425\0435\0439\043b\0441\0431\0435\0440\0433 \0410.');
insert into Authors (Name) values (U&'\0423\0430\0439\0442 \0422.');
insert into Authors (Name) values (U&'\0421\0442\0430\0440\0438\043a\043e\0432 \041d.\0412.');
insert into Authors (Name) values (U&'\041c\043b\0435\0447\0438\043d \041b.\041c.');
insert into Authors (Name) values (U&'\041a\043e\0440\043d\0435\0435\0432\0430 \0415.\0410.');
insert into Authors (Name) values (U&'\042d\0441\043f\043e\0437\0438\0442\043e \0414.');

insert into Series (Genre_Id, Title) values (9, U&'\041a\043b\0430\0441\0441\0438\043a\0430 computer science');
insert into Series (Genre_Id, Title) values (9, U&'\041c\0430\0441\0442\0435\0440-\043a\043b\0430\0441\0441');
insert into Series (Genre_Id, Title) values (9, U&'\0411\0435\0441\0442\0441\0435\043b\043b\0435\0440\044b O''Reilly');

insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (1, 9, 2, U&'\041f\0440\043e\0433\0440\0430\043c\043c\0438\0440\043e\0432\0430\043d\0438\0435 \0441 \0438\0441\043f\043e\043b\044c\0437\043e\0432\0430\043d\0438\0435\043c Microsoft ASP.NET 4', 1531, 2012, 880, '978-5-459-00346-8', U&'\042d\0442\0430 \043a\043d\0438\0433\0430 \043f\0440\0435\0434\0441\0442\0430\0432\043b\044f\0435\0442 \0441\043e\0431\043e\0439 \043d\0430\0438\0431\043e\043b\0435\0435 \043f\043e\043b\043d\043e\0435 \0440\0443\043a\043e\0432\043e\0434\0441\0442\0432\043e \043f\043e Microsoft ASP.NET, \043f\043e\043b\043d\043e\0441\0442\044c\044e \043f\0435\0440\0435\0440\0430\0431\043e\0442\0430\043d\043d\043e\0435 \043f\043e\0434 \0432\0435\0440\0441\0438\044e ASP.NET 4. \0412\044b \0443\0437\043d\0430\0435\0442\0435 \043e\0431\043e \0432\0441\0435\0445 \0432\043e\0437\043c\043e\0436\043d\043e\0441\0442\044f\0445 \0434\0430\043d\043d\043e\0439 \0442\0435\0445\043d\043e\043b\043e\0433\0438\0438, \0432 \0447\0430\0441\0442\043d\043e\0441\0442\0438 \043e\0431 \0438\0441\043f\043e\043b\044c\0437\043e\0432\0430\043d\0438\0438 \0442\0435\043c, \043c\0430\0441\0442\0435\0440\043e\0432 \0438 \0448\0430\0431\043b\043e\043d\043e\0432 \0441\0442\0440\0430\043d\0438\0446, \043f\0440\0438\043c\0435\043d\0435\043d\0438\0438 \0434\0438\043d\0430\043c\0438\0447\0435\0441\043a\0438\0445 \0434\0430\043d\043d\044b\0445 \0434\043b\044f \043f\043e\0441\0442\0440\043e\0435\043d\0438\044f \0438 \043d\0430\0441\0442\0440\043e\0439\043a\0438 \0432\0435\0431-\043f\0440\0438\043b\043e\0436\0435\043d\0438\0439, \0430 \0442\0430\043a\0436\0435 \043e \0440\0430\0431\043e\0442\0435 \0441 Microsoft Silverlight \0438 ASP.NET MVC. \041e\0441\043e\0431\043e\0435 \0432\043d\0438\043c\0430\043d\0438\0435 \0443\0434\0435\043b\044f\0435\0442\0441\044f \0440\0430\0441\0441\043c\043e\0442\0440\0435\043d\0438\044e \0432\043d\0443\0442\0440\0435\043d\043d\0438\0445 \043c\0435\0445\0430\043d\0438\0437\043c\043e\0432 \0438 \043a\043e\043d\0444\0438\0433\0443\0440\0430\0446\0438\0438 ASP.NET, jQuery, AJAX \0438 \043f\0430\0442\0442\0435\0440\043d\043e\0432 \043f\0440\043e\0435\043a\0442\0438\0440\043e\0432\0430\043d\0438\044f.', 'E91CF33E-609D-428A-9F16-49428959913D');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (2, 9, 2, U&'\0412\043d\0443\0442\0440\0435\043d\043d\0435\0435 \0443\0441\0442\0440\043e\0439\0441\0442\0432\043e Microsoft Windows. 6-\0435 \0438\0437\0434.', 1531, 2012, 880, 'Урра', U&'', '3B39B25C-6F4A-45E3-8CE5-F761ABA79C00');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (3, 9, 2, U&'CLR via C#. \041f\0440\043e\0433\0440\0430\043c\043c\0438\0440\043e\0432\0430\043d\0438\0435 \043d\0430 \043f\043b\0430\0442\0444\043e\0440\043c\0435 Microsoft .NET Framework 4.5 \043d\0430 \044f\0437\044b\043a\0435 C#. 4-\0435 \0438\0437\0434.', 1531, 2012, 880, '', U&'', '1D14544D-C0DA-4AE3-AF05-01B5761C6E98');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (4, 9, 1, U&'\041a\043e\043c\043f\044c\044e\0442\0435\0440\043d\044b\0435 \0441\0435\0442\0438. 5-\0435 \0438\0437\0434.', 1531, 2012, 880, '', U&'', 'AB91E937-9C01-4C74-B9FB-ADD1D2645899');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (5, 9, 1, U&'\041e\0431\044a\0435\043a\0442\043d\043e-\043e\0440\0438\0435\043d\0442\0438\0440\043e\0432\0430\043d\043d\043e\0435 \043f\0440\043e\0433\0440\0430\043c\043c\0438\0440\043e\0432\0430\043d\0438\0435 \0432 \0421++.', 1531, 2012, 880, '', U&'', '6FB151FE-9BA2-470E-B846-558A0AAA5D46');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (6, 9, 1, U&'\0410\0440\0445\0438\0442\0435\043a\0442\0443\0440\0430 \043a\043e\043c\043f\044c\044e\0442\0435\0440\0430 \0438 \043f\0440\043e\0435\043a\0442\0438\0440\043e\0432\0430\043d\0438\0435 \043a\043e\043c\043f\044c\044e\0442\0435\0440\043d\044b\0445 \0441\0438\0441\0442\0435\043c.', 1531, 2012, 880, '', U&'', 'D3A38E79-28A2-4D93-AF56-2BD85A416B6F');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (7, 9, 1, U&'\042f\0437\044b\043a \043f\0440\043e\0433\0440\0430\043c\043c\0438\0440\043e\0432\0430\043d\0438\044f C#', 1531, 2012, 880, '', U&'', 'DB2D1F8E-555E-45B0-8D86-787E5CB3A1EE');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (8, 9, 3, U&'Hadoop. \041f\043e\0434\0440\043e\0431\043d\043e\0435 \0440\0443\043a\043e\0432\043e\0434\0441\0442\0432\043e', 1531, 2012, 880, '', U&'', 'cb912ae0-49f8-4b44-812d-fa3844bbc5ff');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (9, 3, null, U&'1917. \0420\0430\0437\0433\0430\0434\043a\0430 "\0440\0443\0441\0441\043a\043e\0439" \0440\0435\0432\043e\043b\044e\0446\0438\0438', 1531, 2012, 880, '', U&'', '749449D4-1B23-4BB6-8958-DAEEED0B0009');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (10, 3, null, U&'\0411\0440\0435\0436\043d\0435\0432. \0420\0430\0437\043e\0447\0430\0440\043e\0432\0430\043d\0438\0435 \0420\043e\0441\0441\0438\0438', 1531, 2012, 880, '', U&'', '623B75CB-63BC-424F-8A0F-70BAB7117013');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (11, 3, null, U&'\0426\0430\0440\0441\0442\0432\043e \041f\0443\0442\0438\043d\0430. \041d\0435\043e\0441\0442\0430\043b\0438\043d\0438\0437\043c \043f\043e \043f\0440\043e\0441\044c\0431\0430\043c \043d\0430\0440\043e\0434\0430', 1531, 2012, 880, '', U&'', '1B30A569-8AD0-4A2E-8048-1FDF9278825B');
insert into Books (author_id, genre_id, series_id, title, price, year, pages, isbn, description, imageFile) values (9, 3, null, U&'\0421\0442\0430\043b\0438\043d. \0412\0441\043f\043e\043c\0438\043d\0430\0435\043c \0432\043c\0435\0441\0442\0435', 1531, 2012, 880, '', U&'', '66D0791F-055D-4D38-B832-DB1A0E673798');

drop table if exists UserConnection;
create table UserConnection (userId varchar(255) not null, providerId varchar(255) not null, providerUserId varchar(255), rank int not null,displayName varchar(255),profileUrl varchar(512),imageUrl varchar(512),accessToken varchar(255) not null,secret varchar(255),refreshToken varchar(255),expireTime bigint, primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);