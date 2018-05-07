package com.zhw1

import java.util.*

/**
 * Created by sfghjtj on 2018/4/8.
 */
class St(name: String, birthDate: Date =Date(), age: Int=18, val school: String?) : Human(name,age,birthDate) {

    constructor(name: String, age: Int) : this(name, Date(), age, null)//如果没有主构造函数，用super调用父类构造函数

}