# 4.27 第二天日记

## 工作

* 安装并且配置IntelliJ IDEA，并且将IDEA连接上git和github
* 安装并且配置Tomcat8.0
* 建立git本地仓库，地址D:\GitRepository
* 根据[学习资料Spring MVC](spring.io/guides/gs/serving-web-content)将git项目clone到本地仓库
* 将clone项目导入到IDEA，完成初步工作，自动下载Spring MVC所需jar包
* 根据[学习资料Spring MVC](spring.io/guides/gs/serving-web-content)和[w3c Spring MVC资料](www.w3cschool.cn/javaweb/eckt1msv.html)学习Spring中的各种注解，例如`@GetMapping，@RequestParam`等
* 创建自己的Spring MVC项目根据[学习资料Spring MVC](spring.io/guides/gs/serving-web-content)初步建立自己的项目（遇到问题，无法按照教程中执行gradlew bootRun指令，提示错误*不是内部或外部命令*，今天没能解决，明天学习的重点）
* 模拟版本冲突，并且解决conflict

## task问题

Q： 工作中为什么会产生版本冲突，版本冲突如何解决

A：

* 为什么会产生：在团队合作过程中，大家共同使用一个仓库获取工作文件，当A和B同时提取了库内文件File1时，A对File1文件修改完成后进行commit操作（记FileA）。此时B也对File1文件进行修改，但是当B进行commit时，此时版本控制工具会进行检查，发现如果此时B将他的FileB进行commit，会对A的修改进行覆盖操作，此时就产生了版本冲突。
* 如何解决：
    1. 解锁-修改-释放：这种方法是通过对当前工作文件进行标记（加锁）实现版本控制。A在库中提取了文件File1，同时对File1添加标记，表示正在被使用，此时B无法从库中提取File1，必须等待A修改好File1，并且提交到库，释放标记后才能进行操作。但是这种方法存在严重的问题，使用这种模式在大规模团队作业中，会大大降低工作效率，并且这种方式也不能保证A修改后的文件被B提取后，B不会覆盖掉A修改的内容。
    2. 拷贝-提交-合并：这种方法是通过在commit时进行版本比对实现版本控制。A在库中update了File1，此时库中FIle1文件的基版本为1，同时B也update了基版本为1的File1文件。A对FIle1文件进行修改后，执行commit操作，此时库文件更新为FIleA，版本为2。这时B也修改完成，进行commit操作，由于FileB文件的基版本为1，此时库中文件基版本为2，B的commit操作失败，需要先进行update获取最新的基版本文件，在此基础上将自己的修改进行合并，再进行commit操作，此时库才能进行更新，库文件更新为FileB，版本为3。当然这种方法能够解决解锁-修改-释放的工作效率低下问题，但是还是无法保证，在B update FileA后对该文件进行修改等操作后，不会覆盖掉A的操作。所以需要工具的辅助。

工具辅助：B在commit失败后，会提示B进行update将本地文件更新到库基版本，B进行update操作会出现conflict状态，并且自动生成相关文件，使用diff来解决冲突（最好通过A,B协商方式进行merge操作，避免覆盖操作）。冲突解决后执行reslove，将生成的文件清理干净，B再进行commit更新到库。

## 明天学习内容（部分）

* 解决今天在SpringMVC上遇到的还未解决的问题
* 学习SpringMVC更多的内容（根据[学习资料Spring MVC](spring.io/guides/gs/serving-web-content)和[w3c Spring MVC资料](www.w3cschool.cn/javaweb/eckt1msv.html)）
* 下载Java从入门到精通第四版PDF，复习Java基础知识部分
* 思考task中的另一个问题