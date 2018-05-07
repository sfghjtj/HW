package com.zhw1

import java.util.*

/**
 * Created by sfghjtj on 2018/4/3.
 */
fun main(args: Array<String>) {
    var a = V()
    val x: Int = 10
    a.handler(object : OnClickLister {
        override fun onclick() {
            println("调用对象表达式")
            println(x)
        }
    })
    val person=object : Person("zhw",Date(),23),OnClickLister{
        override fun onclick() {
            println("实现接口onclick....")
        }

        override fun toString(): String {
            println(x)
            return "Person(name:$name,age:$age)"
        }
    }
    person.onclick()
    person.toString()

    var rect= object {
        var height = 200
        var weight = 300
        override fun toString(): String {
            return ("width=$weight,height=$height")

        }
    }
    println(rect)


}


class V{
    fun handler(listner: OnClickLister) {
        listner.onclick()
    }
}

interface OnClickLister{
    fun onclick()

}



fun callD(user: List<String>) {
    //对数据类解构的过程
    var (n1, n2) = user

}

fun callU(user: User) {
    var (_,name) = user
    println(name)
}