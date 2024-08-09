# users 测试命令

```sh
curl http://localhost:8080/users -X POST
curl http://localhost:8080/users/13 -X DELETE
curl http://localhost:8080/users -X PUT -H "Content-Type:application/json" -d '{"name":"ming","age":"16"}'
curl http://localhost:8080/users/13 -X GET
curl http://localhost:8080/users -X GET
```

# books 测试命令

```sh
curl http://localhost:8080/books -X POST -H "Content-Type:application/json" -d '{"name":"童话","price":100}';
curl http://localhost:8080/books/13 -X DELETE;
curl http://localhost:8080/books -X PUT -H "Content-Type:application/json" -d '{}';
curl http://localhost:8080/books/13 -X GET;
curl http://localhost:8080/books -X GET;
```
