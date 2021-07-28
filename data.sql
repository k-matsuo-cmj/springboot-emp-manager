INSERT INTO employees
(admin, email, kana,login_id, name, password)
VALUES
(true, 'admin@cm.jp', 'せきにんしゃ', 'admin', '責任者', 'admin'),
(true, 'arima@cm.jp', 'ありま', 'arima', '有馬治彦', 'admin'),
(false, 'k.matsuo@cm.jp', 'まつお', 'k.matsuo', '松尾和久', 'user'),
(false, 's.tsuboi@cm.jp', 'つぼい', 's.tsuboi', '坪井翔', 'user')
;

INSERT INTO GROUPS(name,sort_order) VALUES
('役員/管理者',0),
('本社',0),
('営業部',0),
('管理部',0),
('ITサービス事業部',0),
('新生銀行_NSAS',0),
('新生銀行_FBS',0),
('松尾チーム',0),
('竹田チーム',0),
('真下チーム',0),
('二見チーム',0),
('ネーゾーアウンチーム',0),
('金子チーム',0),
('ミョーミンウーチーム',0);
UPDATE GROUPS
SET SORT_ORDER = ID
;

INSERT INTO EMPLOYEES_GROUPS(employees_id, groups_id) VALUES
(1,1),
(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),
(3,5),(3,6),(3,8),
(4,5),(4,8);
UPDATE employees
SET employees.main_group_id =(
 SELECT EG.groups_id
 FROM
 (
  SELECT employees_id, MIN(groups_id) AS groups_id
  FROM employees_groups
  GROUP BY employees_id
 ) EG
 WHERE EG.employees_id = employees.id
);