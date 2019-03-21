# Gradle3.0自动化项目构建技术

### DSL：domain-specific language，领域特定语言
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

### Gradle，远不止一个构建工具，看成是一个构建框架最好
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

---
- [x] **Project，gradle API的入口**
1. Project核心API
2. gradlew projects 命令，输入当前所有gradle的project
3. 一个子Project对应一个输出

4. Project API

![](/png/projectAPI.png)

- project 部分API讲解
```groovy
// 1. 获取全部 projects
this.getAllprojects().eachWithIndex { Project entry, int index ->
//        if (index == 0) {
//            println "Root project: ${project.name}"
//        }else {
//            println "+---Root project: ${project.name}"
//        }
    println "+---Root project: ${project.name}"
}

// 2. 获取子project
this.getSubprojects()

// 3. 获取父project
def getParentProjects(){
    def name= this.getParent().name
    println "the parent project name is ${name}"
}

```
- project 属性讲解
1. gradle默认所有subproject继承rootproject
```
// 1. 获取指定 project，配置子project的gradle，一般不会怎么做
project('app'){Project project->
    println project.name
    apply plugin: 'com.android.application'
//    group 'com.imooc'
//    version '1.0.0-release'
    dependencies {}
    android{}
}

// 2. 配置所有project，包括root和subproject
allprojects {
    group 'com.imooc'
    version '1.0.0-release'
    repositories {
        google()
        jcenter()
    }
}
// 3. 不包括当前结点工程，只包括他的subproject
subprojects { Project project ->
    // 为所有库工程提供上传maven仓库的功能，publishToMaven.gradle文件还没有
    if (project.plugins.hasPlugin('com.android.library')) {
//    apply from: '../publishToMaven.gradle'
    }
}

// rootproject引用配置gradle文件，其他subproject继承rootproject，使用common.gradle内部属性，
// 管理项目配置属性
apply from: this.file('common.gradle')
```

- 依赖相关api
1. compile 所有类或资源都会打包到apk
2. provide 真正打包时候不会输出到apk，能用到的话就用这个
   - 编译期间起作用
   - 被依赖库中已经有相同版本的库，
3. dependencies{
   }

4. 传递依赖最好不要开
   ![](/png/transitive.png)

### Task
- 定义及配置
- 执行详解
- 依赖和执行顺序
- 类型
- 挂接到构建生命周期

---
1. 定义和配置 [RecordOwn](https://github.com/MonkHank/RecordOwn/blob/master/app/build.gradle)
```
// 直接通过task函数去创建，推荐这种方式
task helloTask(group: 'imooc', description: 'task study') {
    println 'i am helloTask.'
    // 第一种方式指定执行阶段
    doFirst {
        println "the task group is ${group}"
    }
    doFirst {}
}
```
2. 依赖 [RecordOwn](https://github.com/MonkHank/RecordOwn/blob/master/app/build.gradle)

3. 输入/输出  [RecordOwn](https://github.com/MonkHank/RecordOwn/blob/master/app/build.gradle)
![](/png/taskinputoutput.png)

4. [task类型](https://docs.gradle.org/current/dsl/org.gradle.api.Task.html)