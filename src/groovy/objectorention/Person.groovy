package groovy.objectorention

/**
 * 1.groovy中默认都是public类型
 * 2.默认集成 GroovyObject 类
 * @author monk
 * @date 2019-03-19.
 */
class Person   {
    String name
    Integer age

    def increaseAge(Integer years){
        this.name+=years
    }

    /**
     * 一个方法找不到时，调用这个方法
     * @param name
     * @param args
     * @return
     */
    def invokeMethod(String name, Object args) {
        return "the method is ${name} the parameter is${args}"
    }

    /**
     * 一个方法找不到时，有下面这个方法，就不执行上面那个方法，执行下面这个方法
     * @param string
     * @param args
     * @return
     */
    def methodMissing(String string, Object args) {
        return "the method is ${string} is missing"
    }
}
