package com.zhw1.s1.s91

import com.google.common.hash.Hashing
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/4/26.
 */

fun main(args: Array<String>) {
    val a = Date().time
    println(a)
    println(TimeUnit.MILLISECONDS.toSeconds(a))
    println(a/1000)
    println(Hashing.md5().hashString( "a29af9526825a0bbd7db07832d2d481f"+a.toString() , Charsets.UTF_8).toString())

}