package groovy.file
/**
 * 文本操作
 * @author monk
 * @date 2019-03-20.
 */

def file = new File('C:\\Users\\Administrator\\IdeaProjects\\HelloGroovy\\ReadMe.md')
// eachLine方法
file.eachLine {line->
    println line
}

println '----------------getText()方法---------------------------------------------'
def text = file.getText()
println text

println '----------------readLines()方法---------------------------------------------'
def lines = file.readLines()
println lines

println '----------------withReader()方法-------------------------------------------'
def reader = file.withReader {reader->
    char []buffer=new char[100]
    reader.read(buffer)
    return buffer
}
println reader

println '----------------copy-----------------------------------------------------'
def strings = copy('C:\\\\Users\\\\Administrator\\\\IdeaProjects\\\\HelloGroovy\\\\ReadMe.md', 'C:\\\\Users\\\\Administrator\\\\IdeaProjects\\\\HelloGroovy\\\\ReadMe2.md')
println strings

def copy(String sourcePaht,String destinationPath) {
    try {
        // 首先创建目标文件
        def desFile=new File(destinationPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        // 读取源文件内容，写入内容
        new File(sourcePaht).withReader {reader->
            def lines=reader.readLines()
            desFile.withWriter {writer->
                lines.each {line->
                    writer.append(line+"\r\n")
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
}

println '----------------对象读写操作------------------------------------------------'
def person=new groovy.objectorention.Person(name: 'Jack',age: 29)
//def object = savaObject(person, 'person.bin')
def object = (groovy.objectorention.Person)readObject('person.bin')
println "the name is ${object.name} the age is ${object.age}"

def savaObject(Object object,String path){
    try {
        // 首先创建目标文件
        def desFile=new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        // 写对象
        desFile.withObjectOutputStream {out->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
}
def readObject(String path){
    def obj=null
    try {
        def file=new File(path)
        if (file==null||!file.exists())return null
        // 从文件读取对象
        file.withObjectInputStream {input->
            obj=input.readObject()
        }
        return obj
    } catch (Exception e) {

    }
}