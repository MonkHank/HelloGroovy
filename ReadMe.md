#### Gradle3.0自动化项目构建技术

> DSL：domain-specific language
- [x] groovy
    - 变量、gstring、循环等基本语法
    - 数据结构：列表，映射，范围
    - 闭包(核心)
    - 面向对象

---
- [x] groovy高级用法
    - groovy json操作详解
    - groovy xml文件操作
    - groovy文件操作
- xml文件详解(java)
    - DOM文件驱动处理
    - SAX时间驱动处理
- 文件操作
    - 节点流（InputStream,OutputStream及其子类）
    - 处理流（Reader,Writer 及其子类）
- 文件操作（groovy)
    - 所有java能处理的，都能处理的
    - 特有操作

---
- [x] 侧重点是写脚本，还有一些高级用法例如连接数据库什么的，这里就不讲解了

- groovy与java对比
    - 写法上：没有java那么多限制
    - 功能上：兼容java所有功能以及自己特有的方法，对java极大的扩展
    - 作用上：既可以编写应用，也可编写脚本，实际开发中，编写脚本要多很多

---
>Gradle，远不止一个构建工具，看成是一个构建框架最好
- [x] gradle 组成
- groovy核心语法
- build script block
- gradle api

---
- [x] gradle优势
1. 灵活性上，ant,maven构建完成后，不能再修改编写脚本
2. 粒度性上，gradle可以修改task，tinker最典型
3. 扩展性上，很多很多插件的复用
4. 兼容性上，兼容ant, maven，吸取其他构建工具的长处

- [x] gradle生命周期探索
1. gradlew clean
2. gradlew build：熟悉gradle生命周期
    - Initialization初始化阶段，解析整个工程中所有Project，构建所有的Project对应的Project对象
    - Configuration配置阶段，解析所有的projects对象中的task，构建好所有task的拓扑图
    - Execution执行阶段，执行具体的task及其依赖task
3. gradle生命周期监听
![](/png/build命令图解.png)