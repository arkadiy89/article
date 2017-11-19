CREATE TABLE IF NOT EXISTS Types (
	ID serial PRIMARY KEY NOT NULL,
  Name varchar(100)
);

CREATE TABLE IF NOT EXISTS Articles (
	ID serial PRIMARY KEY NOT NULL,
  Name text,
  TypeID serial REFERENCES Types (ID)
);

CREATE TABLE IF NOT EXISTS Article_Link (
	Article1_ID integer REFERENCES Articles (ID),
    Article2_ID integer REFERENCES Articles (ID)
);

INSERT INTO types (name)
	 VALUES ('Новости'),
          ('События'),
          ('Спецакции'),
          ('Официальный текст'),
          ('Английский текст');

INSERT INTO Articles (Name, TypeID)
	 VALUES ('Новость 1', 1),
          ('Новость 2', 1),
          ('Спецакция 1', 3),
          ('Новость 3', 1),
          ('Новость 4', 1),
          ('Спецакция 2', 3),
          ('Новость 5', 1),
          ('Официальный текст к новости 2', 4),
          ('Официальный текст к новости 4', 4),
          ('Английский текст к новости 2', 5),
          ('Английский текст к новости 3', 5);

INSERT INTO Article_Link (Article1_ID, Article2_ID)
	 VALUES (2, 8),
          (5, 9),
          (2, 10),
          (4, 11);

SELECT ar.name as "Article_Name", s.count as "Count_Official_Text", s1.count as "Count_English_Text"
FROM  Articles as ar
LEFT JOIN Types as t ON ar.typeid = t.id
LEFT JOIN (
      SELECT al.article1_id, count(typeid)
			FROM Article_Link as al, Articles as ar, Types as t
			WHERE al.article2_id = ar.id AND t.id = ar.typeid and t.name = 'Официальный текст'
			GROUP BY al.article1_id
		      ) as s ON s.article1_id = ar.id
LEFT JOIN (
			SELECT al.article1_id, count(typeid)
			FROM Article_Link as al, Articles as ar, Types as t
			WHERE al.article2_id = ar.id AND t.id = ar.typeid and t.name = 'Английский текст'
			GROUP BY al.article1_id
          ) as s1 ON s1.article1_id = ar.id
WHERE t.id = ar.typeid AND t.name = 'Новости';