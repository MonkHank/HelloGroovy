package groovy.objectorention

/**
 * metaClass用法
 * @author monk
 * @date 2019-03-19.
 */

def person=new Person(name:'Qdroid',age: 26)
println person.cry()

ExpandoMetaClass.enableGlobally()

//为类动态的添加一个属性
Person.metaClass.sex='male'
def person2=new Person(name:'Qdroid',age: 26)
println person2.sex

person2.sex='female'
println "the new sex is ${person2.sex}"

Person.metaClass.sexUpperCase={->sex.toUpperCase()}
def person3=new Person(name:'Qdroid',age: 26)
println person3.sexUpperCase()

Person.metaClass.static.createPerson={String name,int age->new Person(name:name,age:age)}
def person4=Person.createPerson('monk',26)
println person4.name+" and "+person4.age