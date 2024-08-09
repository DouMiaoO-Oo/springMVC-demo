# ssm 框架整合
集成 Spring, SpringMVC, MyBatis

## SQL 依赖
```sql
use learnjdbc;
drop table if exists tbl_book;
create table tbl_book(
  id int primary key auto_increment,
  type varchar(20),
  name varchar(50),
  description varchar(255)
) Engine=INNODB DEFAULT CHARSET=UTF8;

truncate tbl_book;
```

## 测试命令
```sh
curl http://localhost:8080/books -X POST -H "Content-Type:application/json" -d '{"type":"童话","name":"格林童话", "description": "外国经典童话故事"}';
curl http://localhost:8080/books -X POST -H "Content-Type:application/json" -d '{"type":"小说","name":"教父", "description": "外国经典小说"}';
curl http://localhost:8080/books -X POST -H "Content-Type:application/json" -d '{"type":"小说","name":"三体", "description": "外国经典小说"}';

curl http://localhost:8080/books -X PUT -H "Content-Type:application/json" -d '{"id":"3","type":"小说","name":"三体", "description": "中国经典小说"}';
curl http://localhost:8080/books -X GET;
curl http://localhost:8080/books/1 -X GET;


curl http://localhost:8080/books/3 -X DELETE;
curl http://localhost:8080/books -X GET;

```