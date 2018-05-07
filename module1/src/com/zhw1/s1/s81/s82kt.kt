package com.zhw1.s1.s81

import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

/**
 * Created by sfghjtj on 2018/4/19.
 */
fun main(args: Array<String>) {
    println(Date().time)


    println(getB())

}

fun getB2():Int {
    var s=0
    Thread{
        for (i in 0..10000) {
            s=i+s
        }
    }.start()
    return s
}

fun getB() {
    Thread{
        println("start main thread...")
        var s=0
        Thread{
            getC()
        }.start()
        println(s)
    }.apply { start() }
}

fun getC() {
    throw RuntimeException("value error!!!!")
}

fun getA():Int{
    val a:FutureTask<Int> = FutureTask(Callable {
        var s=0

        for (i in 0..10000) {
            s=i+s
        }
        s
    })
    Thread(a).start()
    while (true){
        if(!a.isCancelled){

            println(a.get())
            break
        }
        a.cancel(true)

    }
     return 3
}

data class PP(val name: String, val age: Int)
