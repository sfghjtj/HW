package com.zhw1.s1

/**
 * Created by sfghjtj on 2018/4/8.
 */
class Eclipse : Figure{
    override fun onDrow() {
        println("eclipse drawing...")
    }

    override val name: String
        get() = "椭圆形"
}