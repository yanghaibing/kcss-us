# kcss 说明
> > 1. kcss-admin 后台管理
> > 2. kcss-biz 主要业务代码
> > 3. kcss-core DB工具类
> > 4. kcss-harvester 数据上报信息，使用netty NIO + google protocol buffers 传输协议
> > 5. kcss-job 定时工作任务
> > 6. kcss-monitor 监控
> > 7. kcss-rest RESTful API
# 部署项目

本文档为部署项目的流程指引

在部署之前，有一些硬件和软件上的要求

> **硬件要求：**
>
> > 1. 购买所需的Instance(实例)。由于该项目目标用户在上海，建议购买上海地区的Instance。
> > 2. 足够的机器和配置。配置会在下文提及。

> **软件要求：**
>
> > 1. Ubuntu 14.04+ 
> > 2. JDK 8u101+
> > 3. Gradle 3.5+
> > 4. Docker 1.12+



# 初始化Instance

购买Instance之后，需要对新购买的Instance进行环境初始化，以下为具体的初始化步骤：

##### 安装Linuxbrew

```bash
$ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Linuxbrew/install/master/install)"
```

##### 安装Gradle

```shell
$ brew install gradle
```

#####安装Docker

```shell
$ sudo apt-get update

$ sudo apt-get install \
    linux-image-extra-$(uname -r) \
    linux-image-extra-virtual
    
$ sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common
    
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

$ sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
   
$ sudo apt-get update

curl -L https://github.com/docker/compose/releases/download/1.19.0/docker-compose-`uname-s`-`uname -m` -o /usr/local/bin/docker-compose
$ sudo apt-get install docker-ce docker-compose

$ sudo usermod -aG docker $(whoami)
```

##### 安装Fabric

```shell
$ sudo apt-get install fabric
```



# 准备运行环境

准备运行所需的Docker Container和文件目录

##### 构建Custom JRE Container

在代码的根目录下，键入：

```shell
docker build -t custom-jre:latest .
```

不要忘了后面的小数点



##### 配置运行环境的目录

```shell
应用运行需要三个文件夹，一个放置配置文件，一个放置应用，一个用来存储log，分别为conf、lib、log，这三个文件夹会被挂载到Docker Container的运行环境中

比如

/home/ubuntu/docker-data/rest/conf
/home/ubuntu/docker-data/rest/lib
/home/ubuntu/docker-data/rest/log

另外请在每一个conf文件夹下建立一个application.properties文件

touch application.properties
```



#####进行项目编译并拷贝运行文件

在根目录下执行`gradle -x test`命令，即可对项目进行编译

完成之后，将kcss-rest、kcss-harvester、kcss-admin、kcss-job分别拷贝到每一个运行环境的lib下，如kcss-rest.war拷贝至/home/ubuntu/docker-data/rest/lib/目录下



# 运行应用

准备完成之后，请检查项目根目录下的docker-compose.yml文件内容

将每一个volumes的目录映射检查一遍，确认无误之后，在项目根目录下执行

`docker-compose -f docker-compose.yml up -d`

将文件中的所有应用全部拉起



当然，也可以将单个应用拉起，如

`docker-compose -f docker-compose.yml up -d kcss-rest `



# 配置建议

根据目前应用的功能，参照[阿里云](https://www.aliyun.com/)，推荐以下的Instance配置

| 应用名称      | 最低配置     | 建议配置      |
| --------- | -------- | --------- |
| website   | t2.micro | t2.small  |
| nginx     | t2.micro | t2.small  |
| rest      | t2.small | t2.medium |
| admin     | t2.small | t2.medium |

数据库推荐使用[RDS](https://www.aliyun.com/product/rds/postgresql)，推荐db.m4.large配置

source ~/.bashrc
