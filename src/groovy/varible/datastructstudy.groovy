package groovy.varible

import com.fasterxml.jackson.databind.type.CollectionLikeType

/**数据结构
 * 列表
 * 映射
 * 范围
 * @author monk
 * @date 2019-03-19.
 */

/**
 * 列表：增、删、查、排
 */

//def list=new ArrayList() // java的定义方式

// groovy 定义列表
def list = [1, 2, 3, 4, 5]
println list.class

// 数组的定义
def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]


def sortList = [6, -3, 9, -7, 2, 1, 5]

// java 排序
Comparator mc = { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
Collections.sort(sortList, mc) // 排序（默认从小到大）
println sortList

// groovy更快捷的排序
sortList.sort {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
println sortList

def sortStringList = ['abc', 'z', 'Hello', 'groovy', 'java']
sortStringList.sort { it -> return it.size() }
println sortStringList
println '----------------'

/**
 * 列表的查找 find,findAll
 */
def findList = [-3, 9, 6, 2, -7, 1, 5]
int result = findList.find {
    return it % 2 == 0
}
println result

println findList.findAll {
    return it % 2 != 0
}

println findList.any {
    return it % 2 != 0
}

println findList.every {
    return it % 2 == 0
}

println findList.min()
println findList.min{return Math.abs(it)}
println findList.max()

println findList.count {return it % 2==0}

