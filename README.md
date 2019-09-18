# WorkManagement
作品管理后台。

## 打包

1. 打包之前，需要修改几个配置：

    - log4j.properties 里面的 log 文件路径。
    
    - utils 目录下面的 Constants.java 里面的 WEB_ROOT 路径。
    
    - utils 目录下面的 Constants.java 里面的 FILE_DIR 路径
        FILE_DIR 目录为保存生成的需要下载的 Excel 文件。

2. 打包 
mvn clean package -P production。

3. 将 war 包发布到具体的 tomcat 服务器中。

## 测试账户
管理员： admin/123456

