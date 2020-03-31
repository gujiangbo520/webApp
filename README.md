<b><center>项目介绍</center></b> <br>
本项目是基于SpringBoot + MyBatis + Mysql 集成的项目。项目架构如下：<br>
 Controller 控制层  提供http服务，请求使用json格式。请求方式post + get ,可以自定义。<br>
HttpNorthService 北向接口过滤控制，主要用于记录调用者的日志信息以及相关的业务处理<br>
HttpSorthService 南向接口过滤控制，用于记录本项目调用第三方服务的信息以及相关的业务处理<br>
AOP记录北向接口与南向接口的请求与响应日志，可自定义日志记录的位置<br>
