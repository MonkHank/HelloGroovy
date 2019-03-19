package groovy.objectorention

/**
 * 模拟一个应用管理类
 * @author monk
 * @date 2019-03-19.
 */
class ApplicationManager {

    static void init() {
        ExpandoMetaClass.enableGlobally()
        // 为第三方类添加方法
        Person.metaClass.static.createPerson={String name,int age ->
            new Person(name:name,age:age)
        }
    }
}
