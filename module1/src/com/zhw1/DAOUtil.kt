package com.zhw1

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by sfghjtj on 2018/4/4.
 * object对象声明创建工具类(单例模式)
 */
object DAOUtil {
    init {
        println("hello zhw！")
    }
    fun getNow() = SimpleDateFormat("yyyy-MM-dd").format(Date())

}