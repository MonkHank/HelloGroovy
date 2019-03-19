package groovy.file

import com.google.gson.Gson
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.objectorention.Person

/**
 * @author monk
 * @date 2019-03-19.
 */

def list =[new Person(name:'John',age:25),
           new Person(name:'Major',age:26)]
def json = JsonOutput.toJson(list)
println json

println JsonOutput.prettyPrint(json)

def jsonSlurper = new JsonSlurper()
jsonSlurper.parse()


def response=getNetWorkData('https://www.baidu.com')
println response.data.head.name

def getNetWorkData(String url) {
    // 发送请求
    def connection=new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text

    // 将json转化为实体对象
    def jsonSLuper = new JsonSlurper()
    return jsonSLuper.parseText(response)
}