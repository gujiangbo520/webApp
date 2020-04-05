<p align="center">
	<strong>A simple SpringBoot Project.</strong>
</p>
<p align="center">

## 简介
webApp 是一个基于SpringBoot + Mybatis + Mysql 的整合项目 ，该项目整合了项目中常用的任务模块。

### webApp 项目的结构

### Controller控制层 
Controller控制层为前置系统提供Http POST or GET 等请求服务,请求体采用JSON格式，支持定制请求报文格式。

### HttpNorthManageService 请求服务北向接口
该北向接口主要用于前置系统的请求以及响应做日志记录

### Service 业务逻辑层
该层主要对前置系统请求字段做校验，校验请求头必传参数和请求必传参数。使用者可以扩展该业务逻辑，增加自己的业务处理。

### HttpSorthManageService 请求服务南向接口（尚未发布）
该南向接口主要用于记录本系统调用第三方或者后置系统的请求与响应信息，记录日志

### 定时任务系统（尚未发布）
定时任务常用的场景：<br>
举例：<br>
1、每天定点定时将生产日志打包上传至日志服务器中<br>
2、业务场景中批量处理一批数据<br>
3、每天凌晨将未完成的订单信息输出到制定目录并上传给客户<br>
4、每天23:00对下单客户进行统计<br>
5、......<br>
定时任务好处：<br>
1、可以定时处理业务，无需人工干预<br>

### AOP 日志处理(尚未发布)
该模块会切割截取北向接口与南向接口的请求与响应并生成日志记录。<br>
日志样例：<br>
请求返回码|接口名|请求流向|请求时间|响应时间|耗时|请求头|请求体|响应体|返回描述|流程串Id <br>

### Linux 服务器下Tomcat生成的catalina.out 日志分割
安装步骤:<br>
1、下载（最新版本）<br>
wget http://cronolog.org/download/cronolog-1.6.2.tar.gz<br>
2、解压缩<br>
tar zxvf cronolog-1.6.2.tar.gz<br>
3、进入cronolog安装文件所在目录 <br>
cd cronolog-1.6.2 <br>
4、运行安装 <br>
./configure <br>
make&&make install <br>
5、查看cronolog安装后所在目录（验证安装是否成功） <br>
which cronolog <br>
一般情况下显示为：/usr/local/sbin/cronolog  <br>
要想分割tomcat的catalina.out，需作如下工作： <br>
6.修改tomcat bin目录下的catalina.sh<br>
将文件中的org.apache.catalina.startup.Bootstrap “$@” start  \ 
>> “$CATALINA_BASE”/logs/catalina.out 2>&1 & <br>
改成<br>
org.apache.catalina.startup.Bootstrap "$@" start  2>&1 \
| /usr/local/sbin/cronolog "$CATALINA_BASE"/logs/catalina.%Y-%m-%d.out >> /dev/null &
<br>
去除 touch “$CATALINA_BASE”

### 更新日志
2020/3/30 提交项目<br>
2020/4/1 新增加下单接口，优化代码逻辑<br>
2020/4/3 新增加查询接口




