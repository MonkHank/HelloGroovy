package groovy.varible

/**
 * 变量
 * @author monk
 * @date 2019-03-19.
 */
int x=10
println x.class println()

double y=3.14
println y.class println()

/**
 * 弱类型定义：如果只是在当前类使用的话，那么就这么用，如果被外界用的话，那就得用上面那种
 */
def x_1=11
println x_1.class
def y_1=3.1415
println y_1.class
def name='android'
println name.class

/**
 * 可随意更改类型，def 就是 object
 */
x1='Test'
println x1.class
