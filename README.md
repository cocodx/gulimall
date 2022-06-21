# gulimall
#### 谷粒商城
简介：vue+springboot
##### gulimall-coupon 优惠券服务
##### gulimall-member 会员服务
##### gulimall-order 订单服务
##### gulimall-ware 仓储服务
##### gulimall-product 商品服务

#### 技术搭配方案
* Nacos：注册中心（服务发现/注册）
* Nacos：配置中心（动态配置管理）
* Ribbon：负载均衡
* OpenFeign：声明式HTTP客户端（调用远程服务）
* Sentinel：服务容错（限流、降级、熔断）
* Gateway：API网关（webflux编程模式）
* Sleuth：调用链监控
* Seata：原Fescar：分布式事务解决方案