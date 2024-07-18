# HelloJava
[TOC]

## 1、搭建Java环境

### (1) MacOS

这里主要参考[官方文档](https://docs.oracle.com/en/java/javase/21/install/installation-jdk-macos.html#GUID-F9183C70-2E96-40F4-9104-F3814A5A331F)，介绍MacOS上的搭建步骤，如下

* 确认系统默认JDK版本
* 安装JDK
* 设置JAVA_HOME环境变量
* 验证JDK版本



#### a. 确认系统默认JDK版本

在shell中执行下面命令，如下

```shell
$ java -version
openjdk version "14.0.2" 2020-07-14
OpenJDK Runtime Environment (build 14.0.2+12-46)
OpenJDK 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
```

说明

> 在`/Library/Java/JavaVirtualMachines`路径下，会存放多个jdk，如下
>
> ```shell
> $ ll /Library/Java/JavaVirtualMachines 
> total 0
> drwxr-xr-x  3 root  wheel    96B Aug  6  2020 jdk1.8.0_261.jdk
> drwxr-xr-x@ 3 root  wheel    96B Jul  9  2020 openjdk-14.0.2.jdk
> ```
>
> 使用`/usr/libexec/java_home -v <version> `可以按照版本号来执行java命令，用于打印特定版本jdk的信息，如下
>
> ```shell
> $ /usr/libexec/java_home -v 1.8.0 --exec java -version 
> java version "1.8.0_261"
> Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
> Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
> $ /usr/libexec/java_home -v 14 --exec java -version
> openjdk version "14.0.2" 2020-07-14
> OpenJDK Runtime Environment (build 14.0.2+12-46)
> OpenJDK 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
> ```
>
> 如果`-v`指定不存在的version，则使用默认版本，类似`java -version`，如下
>
> ```shell
> $ /usr/libexec/java_home -v 999 --exec java -version 
> openjdk version "14.0.2" 2020-07-14
> OpenJDK Runtime Environment (build 14.0.2+12-46)
> OpenJDK 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
> ```
>
> 



#### b. 安装JDK

在这个网址，https://www.oracle.com/java/technologies/downloads/下载对应架构的JDK安装包。

下载安装后，会在在`/Library/Java/JavaVirtualMachines`路径多出一个文件夹。



#### c. 设置JAVA_HOME环境变量

修改之前打印下JAVA_HOME环境变量，如下

```shell
$ echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/openjdk-14.0.2.jdk/Contents/Home
```

这里使用zsh，因此修改`~/.zshrc`文件，如下

```shell
export JAVA_HOME=`/usr/libexec/java_home -v 1.8.0`
```

再次打印JAVA_HOME环境变量，如下

```shell
echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home
```

说明

> 如果打印是下面的路径，不是`/Library/Java/JavaVirtualMachines/`路径
>
> ```shell
> echo $JAVA_HOME
> /Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home
> ```
>
> 需要检查`-v`参数是否正确，最后指定完整的版本号



#### d. 验证JDK版本

在shell中执行下面命令，如下

```shell
$ java -version
java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
```

说明

> Java 8的jdk版本号，按照"1.8.x_xxx"的模式。从Java 9开始，dk版本号，按照"jdk-x.jdk"的模式，官方文档描述[^1]，如下
>
> > JDK is installed in `/Library/Java/JavaVirtualMachines/jdk-<FEATURE>.jdk` where `<FEATURE>` is the feature release number. For example, JDK 21.0.1 is installed in `/Library/Java/JavaVirtualMachines/jdk-21.jdk`



## 2、卸载JDK

### (1) MacOS

参考官方文档的[做法](https://docs.oracle.com/en/java/javase/21/install/installation-jdk-macos.html#GUID-F9183C70-2E96-40F4-9104-F3814A5A331F)：找到`/Library/Java/JavaVirtualMachines`路径，查看下面多个jdk，删除需要卸载的jdk。

```shell
$ ll /Library/Java/JavaVirtualMachines
total 0
drwxr-xr-x  3 root  wheel    96B Aug  6  2020 jdk1.8.0_261.jdk
drwxr-xr-x@ 3 root  wheel    96B Jul  9  2020 openjdk-14.0.2.jdk
$ rm -rf /Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/
```





## References

[^1]: https://docs.oracle.com/en/java/javase/21/install/installation-jdk-macos.html#GUID-E8A251B6-D9A9-4276-ABC8-CC0DAD62EA33



