
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

insert into Authors (Name) values ('Руссинович М.');
insert into Authors (Name) values ('Дж. Рихтер');
insert into Authors (Name) values ('Таненбаум Э. С.');
insert into Authors (Name) values ('Лафоре Р.');
insert into Authors (Name) values ('Паттерсон Д.');
insert into Authors (Name) values ('Хейлсберг А.');
insert into Authors (Name) values ('Уайт Т.');
insert into Authors (Name) values ('Стариков Н.В.');
insert into Authors (Name) values ('Млечин Л.М.');
insert into Authors (Name) values ('Корнеева Е.А.');
insert into Authors (Name) values ('Эспозито Д.');

insert into Series (Genre_Id, Title) values (9, 'Классика computer science');
insert into Series (Genre_Id, Title) values (9, 'Мастер-класс');
insert into Series (Genre_Id, Title) values (9, 'Бестселлеры O''Reilly');

