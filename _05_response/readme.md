# 当方法没有 @ResponseBody 注解时
会把 response 返回的文本数据当做当前页面名称去查找

# 当方法上有 @ResponseBody 注解后
- 方法的返回值为字符串，会将其作为文本内容直接响应给前端
- 方法的返回值为对象，会将对象转换成JSON响应给前端



# 测试url
- curl http://localhost:8080/response/toJumpPage
- curl http://localhost:8080/response/toText
- curl http://localhost:8080/response/toJsonPOJO
- curl http://localhost:8080/response/toJsonList
