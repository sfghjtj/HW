package com.zhw1

import java.util.*

/**
 * Created by sfghjtj on 2018/4/3.
 */
open class Person(val name: String, private val birthDate: Date, internal val age: Int) {

    //internal 内部可见，模块内可见
   internal fun display() {
        println("[name:$name,birthDate:$birthDate,age:$age]")
    }

    override fun equals(other: Any?): Boolean {
        return if (other == null || other !is Person) false else name == other.name && age == other.age

    }
}