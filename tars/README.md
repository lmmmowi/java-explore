# Tars

Tars是腾讯开源一套RPC框架，支持多种开发语言。

### 环境搭建
本人在开发环境中使用Docker搭建Tars，主要运行了两个Docker镜像

    docker run --name mysql -e MYSQL_ROOT_PASSWORD='root@appinside' -d -p 3306:3306 -v {mysql_data_path}:/var/lib/mysql mysql:5.6
    docker run -d -it --name=tars --link mysql -e MOUNT_DATA=true -e DBIP={mysql_ip} -e DBPort=3306 -e DBUser=root -e DBPassword=root@appinside -p 3000:3000 -p 12900:12900 -v {tars_data_path}:/data tarsdocker/tars
    
其中3000端口是tars的管理后台，镜像启动后可以通过http://localhost:3000/访问；12900是我在测试示例中用来暴露服务的端口。

### 代码
示例代码分为server和client两部分，其中server需要打包成war包后，通过tars的管理后台进行部署。