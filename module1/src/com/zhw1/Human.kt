package com.zhw1

import java.util.*

/**
 * Created by sfghjtj on 2018/4/4.
 */
open class Human(val name: String? = null, val age: Int = 0, val birthDay: Date? = null) {

    constructor(name: String?, age: Int) : this(name, age, Date())


    val info: String
        get() = "Human{name=$name,age=$age,birthDay=$birthDay}"


}