package groovy.objectorention

/**
 * Person管理类
 * @author monk
 * @date 2019-03-19.
 */
class PersonManger {
    static Person createPerson(String name, int age) {
        return Person.createPerson(name,age)
    }
}
