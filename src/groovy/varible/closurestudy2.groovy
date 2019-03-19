package groovy.varible

/**
 * 闭包关键变量：this,owner,delegate
 * 闭包委托策略
 * @author monk
 * @date 2019-03-19.
 */

def scriptClosure = {
    println "scriptClosure this:" + this // 代表闭包定义处的类(脚本的类)
    println "scriptClosure owner:" + owner // 代表闭包定义处的类或者对象
    println "scriptClosure delegate:" + delegate // 任意对象，默认owner
}
scriptClosure.call()
println '-------------'

// 定义一个内部类
class Person {
    def classClosure = {
        println "classClosure this:" + this // 代表闭包定义处的类(脚本的类)
        println "classClosure owner:" + owner // 代表闭包定义处的类或者对象
        println "classClosure delegate:" + delegate // 任意对象，默认owner
    }

    def say() {
        def classClosure = {
            println "methodClosure this:" + this // 代表闭包定义处的类(脚本的类)
            println "methodClosure owner:" + owner // 代表闭包定义处的类或者对象
            println "methodClosure delegate:" + delegate // 任意对象，默认owner
        }
        classClosure.call()
    }
}

Person p = new Person()
p.classClosure.call()
p.say()
println '------------'

// 闭包中定义一个闭包（这样就和上面不一样了，owner与delegate 和this 就不一样
def nestClosure = {
    def innerClosure = {
        println "innerClosure this:" + this // 代表闭包定义处的类(脚本的类)
        println "innerClosure owner:" + owner // 代表闭包定义处的类或者对象
        println "innerClosure delegate:" + delegate // 任意对象，默认owner
    }
    innerClosure.delegate = p
    innerClosure.call()
}
nestClosure.call()
println '----------'

/**
 * 闭包委托策略，不经常用到，很少用到，框架的时候用到，一般了解即可
 */
class Student{
    String name
    def pretty={"My name is ${name}"}

    @Override
    String toString() {
        return pretty.call()
    }
}

class Teacher{
    String name
}
def stu=new Student(name:'Sara') // 构造方法写法，后面面向对象的时候再说
def tea=new Teacher(name:'Qndroid')
println stu.toString()

stu.pretty.delegate=tea
stu.pretty.resolveStrategy=Closure.DELEGATE_FIRST // 定义闭包策略
println stu.toString()