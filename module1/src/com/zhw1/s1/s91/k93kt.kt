package com.zhw1.s1.s91

import com.zhw1.Account
import java.io.Serializable

/**
 * Created by sfghjtj on 2018/4/28.
 */
fun main(args: Array<String>) {
//    getSS({
//        println(it.gets())
//        kotlin.String
//
//    })
    println(IP::class.qualifiedName)
    println(IP::class.java.name)

}

class IPP: IP{
    override var account: String ="dfdf"
        get() = "dfdf"
        set(value) {field =value}
}

interface IP{
    var account: String
}

data class IIP(var age: Int): IP{
    override var account: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
}

inline fun getSS(s:(SS2)->Unit){
    //println("nihso")
    val a=object : SS2{
        override fun gets(): String {
            return "fdfd"
        }
    }
    println(s(a))
}

interface SS2{
    fun gets(): String
}
