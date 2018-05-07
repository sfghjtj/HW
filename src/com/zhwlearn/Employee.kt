package com.zhwlearn

import kotlin.properties.Delegates

/**
 * Created by sfghjtj on 2018/4/3.
 */
class Employee {

    init {
        println("Employee init...")
    }
    private var firstName="zhao"
    private var lastName = "hw"
    val fullName: String by lazy {
        firstName + "." + lastName
    }

    lateinit var depart:Department

}
class Department{

    init {
        println("Department init...")
    }
    var no = 0
    //var name: String by Delegates.observable()


}