package groovy.varible

/**映射
 * @author monk
 * @date 2019-03-19.
 */

//def map =new HashMap()//

def colorsMap = [red: 'ff0000', green: '00ff00', blue: '0000ff']
println colorsMap

// 索引方式
println colorsMap['red']
println colorsMap.red
// 添加元素
colorsMap.yelllow = 'ffff00'
colorsMap.complex = [a: 1, b: 2]
println colorsMap
println colorsMap.getClass()
println '--------------------------'


def students = [
        1: [number: '0001', name: 'Bot', score: 55, sex: 'male'],
        2: [number: '0002', name: 'Johnny', score: 62, sex: 'male'],
        3: [number: '0003', name: 'Claire', score: 73, sex: 'female'],
        4: [number: '0004', name: 'Amy', score: 66, sex: 'female'],
]

// 遍历
students.each {
    def student -> println "key=${student.key},value=${student.value}"
}

// 带索引遍历
students.eachWithIndex {
    def student, int index -> println "index=${index},key=${student.key},value=${student.value}"
}
// 遍历
students.each { key, value -> println "key=${key},value=${value}" }
println '--------------------------'

//查找，find返回第一个符合条件的，findAll返回所有,count个数
println students.find { def student -> return student.value.score >= 60 }
println students.findAll { def student -> return student.value.score >= 60 }
println students.count { def student -> return student.value.score >= 60 && student.value.sex == 'male' }

// 所有及格人数的姓名
println students.findAll {
    def student -> return student.value.score >= 60
}.collect {
    return it.value.name
}

// 分组
println students.groupBy {
    def student -> return student.value.score >= 60 ? '及格' : '不及格'
}
// 排序，列表是原列表，映射返回的是一个新映射
println students.sort { def student1, student2 ->
    Number score1 = student1.value.score
    Number score2 = student2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? -1 : 1

}