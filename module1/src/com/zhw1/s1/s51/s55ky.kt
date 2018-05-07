package com.zhw1.s1.s51

import java.io.File
import java.util.*

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    date2 {
        val cal=Calendar.getInstance()
        cal.time = this
        cal.set(Calendar.YEAR, 2018)
        println(cal.time)
    }
}

inline fun <R> date2(modify: Date.() -> R) = Date().modify()
inline fun <T> T.objDeal(deal: T.() -> T): T {
    this.deal();return this
}

