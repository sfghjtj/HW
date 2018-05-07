package com.zhw1

import java.util.*

/**
 * Created by sfghjtj on 2018/4/4.
 */
fun main(args: Array<String>) {
    var a = Outer().Inner()
    println(a.display())
}

class Account{
    var name: String = "zhw"
    var amount: Double = 0.0

    companion object  {
        var rate: Double = 0.8
        fun interest(amt: Double): Double {
            return amt * rate
        }
        init {
            println("Factory init...")
        }
    }
}

fun Account.Companion.display(){
    println(rate)
}


interface OnClickListen{
    fun onClick()

}