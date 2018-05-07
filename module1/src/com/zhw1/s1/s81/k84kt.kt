package com.zhw1.s1.s81

import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

/**
 * Created by sfghjtj on 2018/4/25.
 */
fun main(args: Array<String>) {

    val e = Example()
    println(e::class.memberProperties.first().getDelegate(throw RuntimeException("dfd")))
    e.property = "new"
    println(e.property)
}
class Example{
    var property: String by DelegateP()
}

class DelegateP{
    var temp = "old"

    operator fun getValue(ref: Any?,p: KProperty<*>): String {
        return "dfdfdfdf"
    }
    operator fun setValue(ref: Any?,p: KProperty<*>,value: String){
        temp =value
    }
}
