本系统使用指南

本系统使用IDEA + SpringBoot 开发，推荐使用IDEA这个IDE打开。
SpringBoot自带tomcat等容器，所以本系统并不需要另外安装tomcat，直接运行即可。
访问http://localhost:8080进入网站主页
访问http://localhost:8080/admin 进入后台管理页面  登陆账号：admin  密码：admin

由于本系统的数据库并没有放到云端服务器，所以需要在本地数据库中导入sql文件，
sql文件在项目目录：database/excellent_course.sql中，只需导入该文件到数据库即可。
其次还需修改src/main/resources/application.yml中的datasource设置，用户只需修改成自己本地数据库的用户名和密码即可。
