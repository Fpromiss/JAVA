一、model

（1）数据库model （data object）

该层model与数据库字段一一对应

（2）后端model

后端处理业务逻辑model，可能是杂糅

（3）前端model VO（view object）

即前端所需要展示字段集合，避免如密码等透露到前端

二、commonReturnType

（1）是通用返回对象，包含状态码和数据对象

```
// 若status=success 则data返回前端需要的json数据
// 若status=fail 则data内使用通用的错误码格式
```

