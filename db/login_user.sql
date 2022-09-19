-- テーブル作成
CREATE TABLE login_user(
  name varchar(50),
  email_address varchar(50),
  password varchar(10)
);
-- 初期データを挿入
INSERT INTO login_user VALUES('Tarou','tarou@exmple.com','password');
