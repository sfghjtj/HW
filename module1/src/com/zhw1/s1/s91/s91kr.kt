package com.zhw1.s1.s91

import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/4/26.
 */
fun main(args: Array<String>) {

    val timestamp = TimeUnit.SECONDS.toMillis(1524626235167L)
    val mim = Math.abs(System.currentTimeMillis() - timestamp)
    val mind = TimeUnit.MILLISECONDS.toMinutes(mim)
    println(mind)
}

class PP(val name: String, val age: Int)
