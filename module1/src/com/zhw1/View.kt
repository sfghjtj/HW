package com.zhw1

/**
 * Created by sfghjtj on 2018/4/4.
 */
class View {
    val x = 20

    class Button {
        fun onClick() {
            println("onclick...")

        }
    }

    fun test() {
        val b = Button()
        b.onClick()
    }

}