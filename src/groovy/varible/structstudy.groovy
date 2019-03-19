package groovy.varible

/**
 * 逻辑结构
 * @author monk
 * @date 2019-03-19.
 */

def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'find foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [4, 5, 'inlist', 1.23]: // 列表
        result = 'list'
        break
    case 12..30:
        result = 'range' // 范围
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
    default:
        result = 'default'
        break
}
println result
println('-------------')

/** 对范围的for循环*/
def sum = 0
for (i in 0..9) {
    sum += i
}
println sum
sum = 0
/** 对 list循环*/
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 9]) {
    sum += i
}
println sum
sum = 0
/** 对map循环*/
for (i in ['lili': 1, "luck": 2, 'xiaoming': 3]) {
    sum += i.value
}
println sum
