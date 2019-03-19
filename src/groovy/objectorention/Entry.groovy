package groovy.objectorention

/**
 * 给person类永久注入createPerson(string,int)方法
 * @author monk
 * @date 2019-03-19.
 */
class Entry {
    static void main(String[] args) {
        println '应用程序正在启动....'
        // 初始化
        ApplicationManager.init()
        println '应用初始化完成'

        def person = PersonManger.createPerson('jack', 24)
        println "name is ${person.name} age is ${person.age}"
    }
}
