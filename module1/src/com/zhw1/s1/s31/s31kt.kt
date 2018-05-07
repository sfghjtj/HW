package com.zhw1.s1.s31

import java.io.*
import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

/**
 * Created by sfghjtj on 2018/4/10.
 */
var value=0
fun main(args: Array<String>){
//    val t= Thread(object :Runnable {
//        override fun run() {
//            for (i in 0..9) {
//                println("第${i}次执行,${currentThread().name}")
//
//            }
//        }
//    },"thread1")
//    t.start()


    val t=thread(name="thread1") {
        for (i in 0..9) {
            println("子线程开始...")
           // println("第${i}次执行,${currentThread().name}")
            value++
            //sleep(1000L)
            println("子线程结束...")
        }
    }
    var str = readLine()
    //t.join()
    println("value=$value")
//    try {
//        FileInputStream("module1/date.txt").use {
//            InputStreamReader(it).use {
//                BufferedReader(it).use {
//                    var str: String? = it.readLine() ?: null
//                    str?.let { println(SimpleDateFormat("yyyy-MM-dd").parse(it)) }
//                }
//            }
//        }
//    } catch (e: FileNotFoundException) {
//        println("file not found!")
//    } catch (e: IOException) {
//        println("io error!")
//    }

}

fun readParseD(): Date {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    val inp = FileInputStream("module1/date.txt")
    val inr = InputStreamReader(inp, "utf8")
    val br=BufferedReader(inr)
    val strr = br.readLine() ?: null
    return sdf.parse(strr)
}

inline fun <T : Closeable?, R> T.use2(block: (T) -> R): R {
    try {
        return block(this)
    } catch (e: Throwable) {
        throw e
    } finally {
        this?.close()
    }

}