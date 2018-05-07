package com.zhw1.s1.s81

/**
 * Created by sfghjtj on 2018/4/25.
 */
fun main(args: Array<String>) {

    val map = mapOf<String,Any>("name" to 445 as String, "school" to "dzh", "age" to 35)
    val u = User(map)
    println("${u.name}:${u.school}")


}

class User(val m: Map<String, Any>){
    val name: String by m
    val school: String by m
}


