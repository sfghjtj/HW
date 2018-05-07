package com.zhw1.s1.s31

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import java.io.Closeable
import java.lang.Math.random

/**
 * Created by sfghjtj on 2018/4/10.
 */
var value1=0
//fun main(args: Array<String>)= runBlocking {
//    val l=launch {
//        for (i in 0..9) {
//            value1++
//            delay((1000 * random()).toLong())
//        }
//        println("子协程结束")
//    }
//    l.join()
//    println("主协程结束：$value1")
//    withTimeout(2000L){
//
//    }
//}
fun main(args: Array<String>) {
//    var f = getM()
//    println(f)
//    println(f)

    println(TT().name)

}

interface AAAA{
    val a
    get() = 33




}

class TT(){

    var name: String
        get() = "zhw"
        set(value) = println()


}


open class A {
    open val a=0
    open fun getP() = a
}
//重写父类属性会屏蔽父类的属性，即使用父类的方法会调用子类的属性
class B:A(){
    override val a: Int = 10
    override fun getP(): Int {
        return super.getP()
    }
}


fun getM(): () -> Int {
    var a = 0
    return {    //闭包将捕获局部变量a,导致整个闭包在使用的过程中不会释放a,它会单独存储一份
        a++
    }
}
