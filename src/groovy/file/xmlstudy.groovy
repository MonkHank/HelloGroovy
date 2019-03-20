package groovy.file

import groovy.xml.MarkupBuilder

/**
 *
 * @author monk
 * @date 2019-03-19.
 */


final String xml='''
<response version-api="2.0">
    <value>
        <books id="1" classification="android">
            <book available="20" id="1">
                <title>疯狂android讲义</title>
                <author id="1">李刚</author>
            </book>
             <book available="14" id="2">
                <title>第一行代码</title>
                <author id="1">郭林</author>
            </book>
             <book available="13" id="3">
                <title>Android开发艺术探索</title>
                <author id="1">任玉刚</author>
            </book>
         </books>
         
         <books id="2" classification="java">
            <book available="20" id="1">
                <title>java源码设计</title>
                <author id="1">李刚</author>
            </book>
            <book available="20" id="2">
                <title>android源码情景分析</title>
                <author id="1">罗申阳</author>
            </book>
         </books>
    </value>
</response>
'''

// 开始解析xml数据
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)

println response.value.books[0].book[0].title.text()
println response.value.books[0].book[1].@available
println response.value.books[0].book[0].author.text()

println '-------------'
def list=[]
response.value.books.each{books->
    books.book.each{book->
        def author=book.author.text()
        if ('李刚'.equals(author)) {
            list.add(book.title.text())
        }
    }
}
println list

println '---------------深度遍历xml数据-------------'
// 深度遍历xml数据
def tiltes=response.depthFirst().findAll{book ->
    return book.author.text() == '李刚'
}
println tiltes

println '----------------广度遍历xml数据------------'
// 广度遍历xml数据
def name = response.value.books.children().findAll{node->
    node.name()=='book'&&node.@id=='2'
}.collect{node->
    return node.title.text()
}
println name

println '--------------生成xml格式数据-------------'
/**
 * 生成xml格式数据
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)
// 根节点lansg创建成功
xmlBuilder.lanns(type:'current',count:'3',mainstream:'true'){
    //第一个language节点
    language(flavro:'static',version:'1.5',value:'java'){
        age(value: '16')
    }
    language(flavro:'dynamic',version:'1.5',value:'Groovy'){
        age(value: '10')
    }
    language(flavro:'static',version:'1.9',value:'JavaScript')
}
println sw

println '--------------生成xml格式数据2-------------'
def langs=new Langs()
xmlBuilder.langs(type:langs.type,count:langs.count,mainstream:langs.manistream){
    // 遍历所有节点
    langs.languages.each {lang->
        language(flavor:lang.flavor,version:lang.version,lang.value)
    }
}
print sw
// 对应xml中的langs结点
class Langs{
    String type='current'
    int count =3
    boolean manistream=true
    def languages=[new Language(flavor: 'static',version: '1.5',value: 'Java'),
                   new Language(flavor: 'dynamic',version: '1.3',value: 'Groovy'),
                   new Language(flavor: 'dynamic',version: '1.6',value: 'JavaScript')]
}

class Language{
    String flavor,version,value
}