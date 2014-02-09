
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

