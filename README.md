# sql-easy 🚀

sql-easy是一个用于生成SQL语句的工具，它可以帮助开发人员更快速、更准确地生成各种类型的SQL语句，
包括创建表、插入数据、更新数据和查询数据等操作。
通过简单的配置和参数输入，该工具能够自动生成符合特定需求的SQL语句，提高开发效率并减少错误。

## 技术栈

- 💚 Spring Boot 3.x：使用最新版本的Spring Boot进行开发。
- 📝 MyBatis：使用MyBatis进行数据库操作。
- 📦 MyBatis Plus：使用MyBatis Plus提供更多便捷的数据库操作功能。
- 🧰 Lombok：使用Lombok简化Java代码的编写。
- 🔒 Jasypt：使用Jasypt进行加密和解密操作。
- 📝 Slf4j：使用Slf4j进行日志记录。
- 🎯 AOP：使用AOP实现面向切面编程。
- 📚 Jackson：使用Jackson进行JSON数据的序列化和反序列化。
- 📚 Hutool：使用Hutool提供更多实用的Java工具类。
- 📚 Knife4j：使用Knife4j生成API文档。
- 📚 spring-validation：spring校验器
- 📚 easyexcel：表格生成
- 📚 jwt：token验证

![spring-boot](https://img.shields.io/badge/spring--boot-3.x-brightgreen)
![mybatis](https://img.shields.io/badge/mybatis-3.5.6-lightblue)
![mybatis-plus](https://img.shields.io/badge/mybatis--plus-3.4.5-green)
![lombok](https://img.shields.io/badge/lombok-1.18.22-pink)
![jasypt](https://img.shields.io/badge/jasypt-3.0.4-orange)
![slf4j](https://img.shields.io/badge/slf4j-1.7.32-red)
![aop](https://img.shields.io/badge/aop-5.3.9-purple)
![jackson](https://img.shields.io/badge/jackson-2.13.0-lightgrey)
![hutool](https://img.shields.io/badge/hutool--all-5.7.9-blueviolet)
![knife4j](https://img.shields.io/badge/knife4j-3.0.2-brightgreen)

## 开发环境要求

- 📌 JDK：请确保你的JDK版本在11以上。
- 📌 Maven：请确保你的Maven版本在3.6以上。

## 初始化项目

克隆或下载该项目后，进入项目根目录，执行以下命令来安装依赖：

```shell
mvn clean install
```

## 目录树形结构

```
├── src/                           # 源代码目录
│   ├── main/                      # 主目录
│   │   ├── java/                  # Java代码目录
│   │   │   ├── config/            # 配置类
│   │   │   ├── controller/        # 控制器类
│   │   │   ├── core/            # 核心包
│   │   │   ├── interceptors/            # 拦截器
│   │   │   ├── model/            # 数据库实体类
│   │   │   ├── mapper/            # MyBatis映射接口
│   │   │   ├── service/           # 服务类
│   │   │   ├── utils/              # 工具类
│   │   │   ├── SqlEasyApplication.java   # Spring Boot应用入口
│   │   ├── resources/             # 资源文件目录
│   │   │   ├── application.yml    # 应用配置文件
│   │   │   ├── application-prod.properties    # 生产应用配置文件
│   │   │   ├── application-test.yml    # 测试应用配置文件
│   │   │   ├── application-dev.yml    # 开发应用配置文件
├── .gitignore                     # Git忽略文件配置
├── pom.xml                        # Maven配置文件
├── .gitignore                     # Git忽略文件配置
└── spring-boot-template.iml       # IntelliJ IDEA项目文件

## 使用流程

1. 初始化项目（参考上述步骤）。
2. 开发你的应用，根据需要修改或添加控制器、服务类、数据库实体类等。
3. 在 `src/main/resources` 目录中配置你的应用配置文件，例如数据库连接信息、日志配置等。
5. 在 `src/main/java/mapper` 目录中使用 MyBatis 注解或 XML 文件配置数据库操作。
6. 在 `src/main/java/service` 目录中编写你的服务类，实现业务逻辑。
7. 在 `src/main/java/controller` 目录中编写你的控制器类，处理请求和返回响应。
8. 在开发过程中使用 Git 进行版本控制，确保代码的可追踪性和团队协作。具体使用方式请参考 [Git 文档](https://git-scm.com/doc)。

9. 在完成开发后，可以使用 Maven 进行项目的构建。具体使用方式请参考 Maven 的官方文档。

## 开发注意事项

- 确保你的项目使用了 Spring Boot 3.x 版本。
- 在开发过程中，推荐使用 IntelliJ IDEA 编辑器，并安装相关插件，例如 Lombok 插件，以提升开发效率。
- 遵循 Git 的代码提交规范，使用语义化的提交信息，方便版本管理和发布。

## 使用方法

1. 安装依赖：

```shell
mvn clean install
```

2. 启动应用：

```shell
mvn spring-boot:run
```

3. 在浏览器中打开 [http://localhost:8080](http://localhost:8080) 进行开发。

4. 构建项目：

```shell
mvn clean package
```

5. 构建完成后，可以在`target`目录中找到构建后的文件。

## 贡献

欢迎贡献代码，提出问题和建议。请在提交代码前确保通过了代码检查。

## 许可证

本项目基于 MIT 许可证开源。

## 鸣谢

感谢以下开源项目的贡献：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MyBatis](https://mybatis.org/mybatis-3/)
- [MyBatis Plus](https://mybatis.plus/)
- [Lombok](https://projectlombok.org/)
- [Jasypt](https://github.com/ulisesbocchio/jasypt-spring-boot)
- [Slf4j](http://www.slf4j.org/)
- [AOP](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop)
- [Jackson](https://github.com/FasterXML/jackson)
- [Hutool](https://hutool.cn/)
- [Knife4j](https://doc.xiaominfo.com/)

---

# 部署
在deploy文件夹中，存在已写好的Dockerfile配置文件，可以根据实际情况进行修改和部署

🚀 如果有任何问题或建议，请随时提出。祝你编码愉快！
