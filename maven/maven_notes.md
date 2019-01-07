## HelloMaven

[TOC]

### 1、介绍Maven

Maven基于Java的工程管理工具。一般IDE工具，例如Eclipse，集成了maven的工程模板。

下面介绍MacOS X下的maven命令行的使用方式。



#### （1）安装maven

```shell
$ brew install maven
```



#### （2）创建maven工程

```shell
$ mvn archetype:generate
```

输入上面的命令，进入交互式创建工程环境。其中需要填写下面几项。

* groupId，组名
* artifactId，工程名
* package，包名。可不填，则和组名一样

完成上面配置后，maven命令生成下面的工程结构，如下

```
.
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── wc
    │               └── App.java
    └── test
        └── java
            └── com
                └── wc
                    └── AppTest.java
```

`pom.xml`文件是maven工程配置文件。



也可以使用下面命令，直接生成maven工程，不用进入交互式环境[^1]。

```shell
$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```



#### （3）maven命令

在maven工程中，可以使用maven命令来完成特定任务。比如使用`mvn package`编译工程



常用phase命令，如下

| Command | Comment |
|---------|---------|
| mvn package | 打包 |
| mvn compile | 编译应用程序源码 |
| mvn test | 运行测试程序 |
| mvn test-compile | 编译测试程序源码 |
| mvn install | 安装应用程序。位置：~/.m2/repository |
| mvn site | 生成文档。位置：target/site |
| mvn clean | 删除target文件夹 |



运行maven工程，并不使用mvn命令，还是使用java命令，如下

```shell
$ java -cp target/HelloMaven-1.0-SNAPSHOT.jar com.wc.App           
Hello World!
```





## References

[^1]: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

