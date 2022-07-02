# gulimall
#### 谷粒商城
简介：vue+springboot
##### gulimall-coupon 优惠券服务🔥
##### gulimall-member 会员服务✨
##### gulimall-order 订单服务❤️
##### gulimall-ware 仓储服务🏜️
##### gulimall-product 商品服务🌋
##### gulimall-common 公共依赖组件🏕️
##### renren-generator CRUD代码生成器🗺️

#### 技术搭配方案
* Nacos：注册中心（服务发现/注册）
* Nacos：配置中心（动态配置管理）
* Ribbon：负载均衡
* OpenFeign：声明式HTTP客户端（调用远程服务）
* Sentinel：服务容错（限流、降级、熔断）
* Gateway：API网关（webflux编程模式）
* Sleuth：调用链监控
* Seata：原Fescar：分布式事务解决方案

##### renren-generator
**具体使用**
- 项目启动后，[访问地址http://localhost/](http://localhost/)，进入操作界面下载表的代码

修改文件 generator.properties
```js
#主要包路径
mainPath=com.lg.gulimall
#包名
package=com.lg.gulimall
#模块名字
moduleName=product
#作者
author=liugang
#Email
email=2cevening@gmail.com
#表前缀
tablePrefix=pms_
```
修改文件 application.yml
```aidl
修改连接数据的url地址和root还有password
```
##### nacos配置规则使用
每个微服务创建自己的命名空间，使用配置分组区分环境，dev，test，prod  


#### TODO
***
1. - [x] 集成nacos-client做服务注册，发现😊
2. - [x] 集成openFeign相互调用🦠
3. - [x] 集成nacos-client做配置管理🧫
4. - [x] gateway做网关路由🛢️
5. - [ ] es全文检索🧭
6. - [ ] redis分布式锁🎊
7. - [ ] spring cache本地缓存⏲️
8. - [ ] 检索服务🌡️
9. - [ ] 认证服务⛱️
10. - [ ] 消息队列🎐
11. - [ ] seata分布式事务🎀
12. - [ ] 支付宝🍹
13. - [ ] 秒杀💚
13. - [ ] sentinel限流，流控🌱
13. - [ ] redis集群🥗
13. - [ ] es集群🥬
13. - [ ] rabbitmq镜像集群🍺

#### 解决跨域
##### 使用nginx部署为同一域
从头到尾都是nginx代理，同一域
##### 配置当次请求允许跨域
* Access-Control-Allow-Origin: 支持哪些来源的请求跨域
* Access-Control-Allow-Methods: 支持哪些方法跨域
* Access-Control-Allow-Credentials: 跨域请求默认不包含cookie，设置为true可以包含cookie
* Access-Control-Expose-Headers: 跨域请求暴露的字段
* Access-Control-Max-Age: 表明该响应的有效时间为多少秒

#### 集成skywalking
##### 启动主函数，添加vm参数
```xml
-javaagent:D:/skywalking/skywalking-agent/skywalking-agent.jar
-Dskywalking_config=D:/skywalking/skywalking-agent/config/agent.config
-Dskywalking.collector.backend_service=192.168.125.101:11800
-Dskywalking.agent.service_name=gulimall-gateway
```

#### 集成minio
##### 进入minio目录，打开cmd输入一下命令
```shell
minio.exe server /data
```
<http://localhost:9000>

登录名称：minioadmin  
登录密码：minioadmin  