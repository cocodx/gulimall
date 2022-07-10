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
* minio: 分布式文件存储🚚✈️

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

#### product表结构分析

##### pms_brand
pms_brand 对应电商系统品牌 例如下图
![image](https://github.com/cocodx/Java-doc/blob/master/images/Snipaste_2022-07-10_17-53-09.png)
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand`  (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌名',
  `logo` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌logo地址http链接',
  `descript` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '品牌介绍',
  `show_status` tinyint(4) NULL DEFAULT NULL COMMENT '显示状态[0-不显示；1-显示]',
  `first_letter` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '检索首字母',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '品牌' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

##### pms_category
pms_category 对应京东的首页三级分类 例如下图
![image](https://github.com/cocodx/Java-doc/blob/master/images/Snipaste_2022-07-10_18-15-24.png)
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category`  (
 `cat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
 `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
 `parent_cid` bigint(20) NULL DEFAULT NULL COMMENT '父分类id',
 `cat_level` int(11) NULL DEFAULT NULL COMMENT '层级',
 `show_status` tinyint(4) NULL DEFAULT NULL COMMENT '是否显示[0-不显示，1显示]',
 `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
 `icon` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标地址',
 `product_unit` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位',
 `product_count` int(11) NULL DEFAULT NULL COMMENT '商品数量',
 PRIMARY KEY (`cat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1436 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品三级分类' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

##### pms_attr_group
pms_attr_group 对应京东商品三级分类的 属性分组SPU、SKU（我还不太懂）
![image](https://github.com/cocodx/Java-doc/blob/master/images/)
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_group`;
CREATE TABLE `pms_attr_group`  (
  `attr_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `attr_group_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组名',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `descript` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组图标',
  `catelog_id` bigint(20) NULL DEFAULT NULL COMMENT '所属分类id',
  PRIMARY KEY (`attr_group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '属性分组' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

##### pms_category_brand_relation

比如说，小米品牌既造手机，就有手机的分类，又造汽车，又有汽车的分类，又造电视，就有电视的分类，多对多的。
一个分类，肯定有很多个品牌。

pms_category_brand_relation 对应京东三级分类 - 关联 - 品牌
![image](https://github.com/cocodx/Java-doc/blob/master/images/Snipaste_2022-07-10_18-34-13.png)
![image](https://github.com/cocodx/Java-doc/blob/master/images/Snipaste_2022-07-10_18-40-08.png)
##### 
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_category_brand_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_category_brand_relation`;
CREATE TABLE `pms_category_brand_relation`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`brand_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌id',
`catelog_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
`brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`catelog_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '品牌分类关联' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

#### 

##### pms_attr_group
pms_attr_group 对应具体商品的主题规格参数的主体信息 - 商品分类 - 商品
![image](https://github.com/cocodx/Java-doc/blob/master/images/Snipaste_2022-07-10_20-03-18.png)
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_group`;
CREATE TABLE `pms_attr_group`  (
  `attr_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `attr_group_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组名',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `descript` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组图标',
  `catelog_id` bigint(20) NULL DEFAULT NULL COMMENT '所属分类id',
  PRIMARY KEY (`attr_group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '属性分组' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

##### 
