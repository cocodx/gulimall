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

#### TODO
1. - []集成nacos-client做服务注册，发现
2. - []集成openFeign相互调用
