package groovy.varible

/**
 * 闭包概念，闭包参数，闭包返回值
 * 使用起来比较灵活
 * @author monk
 * @date 2019-03-19.
 */

/**
 *  -> 前面为参数，后面为结果
 */
def clouse0 = { String name -> println "hello ${name}" }
clouse0.call('groovy')
//clouse0()
def name = 'world'
clouse0(name)
println('---------')

/**
 * 闭包隐式含有一个 it
 */
def closure1 = { println "hello ${it}" }
closure1('groovy')
println('--------')

/**
 * 闭包一定有返回值
 */
def closure2 = { String name2 -> return "Hello ${name2}" }
println closure2("hello")

def closure3 = { String name3 -> println("hello${name3}") }
println closure3("name3") // null 也是返回值
println '--------------'

/**闭包的用法：
 *  与基本类型的结合使用
 *  与string结合使用
 *  与数据结构结合使用
 *  与文件等结合使用
 */

/**
 * 求指定 number 的阶乘
 */
println fab(5)
println fab2(5)

int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

int fab2(int number) {
    int result = 1
    // 闭包放在内部和外部效果一样
    number.downto(1) { num -> result *= num }
    return result
}

println call(101)
/**
 * 累加
 */
int call(int number) {
    int result
    // 这种写法是最常见的写法，方法的参数是闭包，可以拿出来
    // num 需要看源码，源码里面的闭包调用参数传的的是什么，是多少个，再来决定
    number.times {
        num -> result += num
    }
    return result
}

println '----------------'

/**
 * 与 string 结合使用
 */
String str = 'the 2 and 3 is 5'
// each的遍历，如果闭包作为参数的最后一个，可以直接放到外面
str.each {
    temp -> print temp.multiply(2)
}
println()
// find 查找符合条件的第一个
println str.find {
    s -> s.isNumber()
}

def list=str.findAll{s-> s.isNumber()}
println list.toListString()

def result =str.any{s -> s.isNumber()}
println result

println str.every {s->s.isNumber()}

println str.collect {s -> s.toUpperCase()}