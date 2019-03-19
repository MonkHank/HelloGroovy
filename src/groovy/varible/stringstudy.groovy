package groovy.varible

/**
 * 字符串
 * @author monk
 * @date 2019-03-19.
 */
/**
 * java中双引号，groovy中单引号，完全没有区别（不常用）
 */
def name = 'a single \'a\'string'
println name
println name.class
println('------------')

/**
 * 三引号按照原格式输出（不常用）
 */
def thupleName = '''\
line one
line two 
line three'''
println thupleName
println thupleName.class
println('------------')

/**
 * 双引号定义，可扩展字符串（常用）
 */
def doubleName = "this is a common string"
println doubleName.class
println('------------')

def nameOriginal = "Qndroid"
def sayHello = "hello:${nameOriginal}"
println sayHello
println sayHello.class
println('------------')

/**
 * 可扩展任意的表达式
 */
def sum = "The sum of 2 and 3 equals ${2 + 3}"
println sum
println sum.class
println('------------')

/**
 * gstring 转 string ，不用刻意区分到底是 gstring 还是 string
 */
def result = echo(sum)
println result
println result.class

String echo(String message) {
    return message
}

println('--------------')

/**===============字符串的方法==================*/
def str = "groovy Hello"
println str.center(str.length() + 2, 'a')
println str.padLeft(8, 'a')

def str2 = 'Hello'
println str > str2
println str[0]
println str[0..1]
println str.minus(str2) // 减法
println str - str2
println str.reverse()
println str.capitalize()// 首字母大写
println str.isNumber() // 判断是否为数字类型字符串
//println str.toLong() // 字符串转 long
print('--------------')
