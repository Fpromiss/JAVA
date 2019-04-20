一、model

（1）数据库model （data object）

该层model与数据库字段一一对应

（2）后端model

后端处理业务逻辑model，可能是杂糅

（3）前端model VO（view object）

即前端所需要展示字段集合，避免如密码等透露到前端

二、http Statue

（1）commonError是通用返回对象，包含状态码和数据对象

```
// 若status=success 则data返回前端需要的json数据
// 若status=fail 则data内使用通用的错误码格式
```

（2）EmBusinessError 可扩展性错误码

（3）BusinessException 包装器业务异常实现

三、BaseController

（1）定义基础controller，用于异常接收处理

四、前端

（1）METRONIC静态模板

（2）跨域请求

后端：@CrossOrigin(allowCredentials = "true", allowedHeaders = "*") 

前端：xhrFields:{withCredentials:true},

五、加密

MD5加密：正常16位，容易null，需要自己改写为64位

六、自增id问题

（1）自增id取出赋值时候，默认会变为0，需要在mapper文件中定义

```
<insert id="insertSelective" parameterType="com.miaoshaproject.dataobject.UserDO" keyProperty="id" useGeneratedKeys="true">
```