package groovy.objectorention

/**
 * 创建个脚本文件
 * 2.无论直接.还是调用get/set最终都是调用get/set
 * @author monk
 * @date 2019-03-19.
 */

def person=new Person(name:'Qndroid',age: 26)
println "name:${person.name},age:${person.age}"
println "name:${person.getName()},age:${person.getAge()}"