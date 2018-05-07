package com.zhw1

/**
 * Created by sfghjtj on 2018/4/4.
 */
enum class WeekDays(private val wname: String, private val index: Int) {

    //枚举常量列表
    MONDAY("星期一",0),TUESDAY("星期二",1),WEDNESDAY("星期三",2),THURSDAY("星期四",3), FRIDAY("星期五",4);

    override fun toString(): String {
        return "WeekDay:(wname=$wname,index=$index)"

    }
}