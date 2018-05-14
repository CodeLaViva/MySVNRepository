# 5.13 第十八天日记

## 今天学习进度

* 完成 hibernate 连接 postgreSQL
* 编写 `hibernate.cfg.xml` 文件，作为 hibernate 的配置文件
* 编写相应实体类作为投票程序的对象
* 编写 `HibernateUtil` 类作为hibernate操作数据库的 util ，其他 dao 通过该 util 访问数据库
* 解决昨天使用全注解遇到的问题（暂时不使用 hbm 映射文件）
* 编写 login 等 html 文件框架作为投票程序的页面
* 编写 controller 作为投票程序的 controller
* 通过 SpringMVC 对相应的注解进行注入， 并且测试成功

## 问题

* 在使用 hibernate 时，使用全注解方式出现 无法识别 Entity 的 bug，clean工程后就解决了
* cannot reslove Id/ cannot reslove Column 这两个错误是IDEA自身的问题，能够正常运行
* hibernate 在使用全注解创建表的时候 由于使用的是TreeMap， 会对参数进行自动排序，会给数据插入带来很大的影响，可以通过修改 hibernate 包内的方法， 将 TreeMap 更改为 LinkedHashMap（暂时时间不够，以后更改）， 这样就不会对参数进行自动排序了