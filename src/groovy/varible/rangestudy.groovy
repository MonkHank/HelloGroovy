package groovy.varible

/**
 * 选择语言的时候还是要适合自己，并不是一出来就去学习，学习一门语言还不是很容易的，慎重
 */

/**范围，说到底也是一个列表
 * each、switch-case
 * @author monk
 * @date 2019-03-19.
 */


def range=0..10
println range
println range[5]
println range.contains(10)
println range.from
println range.to
println range.class
println'-----------------------'

// 遍历，在groovy中有循环的地方，可以考虑是不是可以用闭包
range.each {print it}
println()

for (i in range) {
    print i
}
println()

println getGrade(75)
def getGrade(Number number) {
    def result
    switch (number) {
        case 0..60:
            result='不及格'
            break
        case 60..70:
            result='及格'
            break
        case 70..80:
            result='良好'
            break
        case 80..100:
            result='优秀'
            break
    }
    return result
}