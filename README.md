## PKUToDo后端部分
&emsp;&emsp;开发工具、环境和技术栈都是目前用到的，后续可继续添加
### 开发工具
| 工具             | 说明                | 官网                                            |
|----------------| ------------------- | ----------------------------------------------- |
| IDEA（2024.1.1） | 开发IDE             | https://www.jetbrains.com/idea/download         |
| Navicat（17）    | 数据库连接工具      | https://www.navicat.com/en/download/navicat-for-mysql            |

### 开发环境
| 工具          | 版本号 | 下载                                                         |
| ------------- |-----| ------------------------------------------------------------ |
| JDK           | 17  | https://www.oracle.com/java/technologies/downloads/|
| MySQL         | 8.3 | https://www.mysql.com/                                       |

### 技术栈
| 技术                 | 说明             | 官网                                           |
| -------------------- |----------------| ---------------------------------------------- |
| SpringBoot           | Web应用开发框架      | https://spring.io/projects/spring-boot         |
| MyBatis              | ORM框架          | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | 数据层代码生成器       | http://www.mybatis.org/generator/index.html    |
| Lombok               | Java语言增强库      | https://github.com/rzwitserloot/lombok         |
| Swagger-UI           | API文档生成工具+接口测试 | https://github.com/swagger-api/swagger-ui      |


### 项目结构
``` plaintext
edu.pku.pkutodobackend
├── config: 配置类
├── controller: 控制器类，处理HTTP请求并将请求分发给相应的服务层处理
├── dao: 数据访问对象目录，用于存放与数据库交互的接口。用于较复杂的自定义查询
├── dto: 数据传输对象目录, 用户不同层之间的数据传输
├── enums: 枚举类型目录,存放枚举类型
├── mapper: 映射器目录，存放Mapper接口和SQL映射文件(resources/edu.pku.pkutodobackend.mapper)，用于简单的单表查询
├── model: 模型类目录，通常存放实体类，即与数据库表结构对应的JavaBean
├── service: 业务逻辑层目录，存放实现业务逻辑的服务类
├── utils: 工具类目录
├── VO: 前端展示层实体类
```

### Done
- 实现单人登录注册功能

### ToDo
&emsp;&emsp;目前登录和注册不支持多用户，因为直接将验证码缓存在了对象里。并且用户密码没有加密传输和存储。因此接下来打算实现：
- 将验证码和登录token缓存在redis，过期时间设置为3min和3d（可调整）
- 用户密码的加密
