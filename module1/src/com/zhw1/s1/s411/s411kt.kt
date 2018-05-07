package com.zhw1.s1.s411

import java.io.*
import java.net.Socket
import java.nio.charset.Charset

/**
 * Created by sfghjtj on 2018/4/11.
 */
fun main(args: Array<String>) {
    println(FileInputStream("module1/date.txt").use { fis ->
        FileOutputStream("module1/date1.txt").use { fos ->
            fis copyTo2 fos
        }
    })
    2.also {  }
    FileInputStream("module1/date.txt").use { it.bufferedReader().use { it.lineSequence().forEach { println(it) } } }
    FileInputStream("module1/date.txt").use { it.bufferedReader().useLines {it.forEach { println(it) }  }}
    FileInputStream("module1/date.txt").use { it.reader().forEachLine { println(it) } }
    println(FileInputStream("module1/date.txt").use { it.reader().readText() })
    FileReader("module1/date.txt").use { fr ->
        FileWriter("module1/date2.txt").use { fw ->
            fr.buffered().use { bis ->
                fw.buffered().use { bos ->
                    bis.copyTo(bos)
                }
            }
            println("copy end!")
        }
    }

    File("module1").walkTopDown()


}




class A private constructor(private val name: String?, private val age: Int?, private val school: String?) {

    internal constructor(name: String, age: Int,likes: List<String>):this(name,age,null)
    var likes: List<String>?
    get() {
        return null
    }
    set(value) = value.let {this.likes=value;return@let  }
}


inline fun <T : Closeable,R> T.use2(block: (T) -> R): R {
    return block((this))
}

inline fun <T> Reader.useLines2(block: (Sequence<String>) -> T): T {
    return this.buffered().use { block(it.lineSequence()) }
}

inline infix fun InputStream.copyTo2(out: OutputStream): Long {
    var res: Long = 0
    var ib = ByteArray(1024)
    var sb = this.read(ib)
    while (sb > 0) {
        out.write(ib, 0, sb)
        res+=sb
        sb=this.read(ib)
    }
    return res
}
