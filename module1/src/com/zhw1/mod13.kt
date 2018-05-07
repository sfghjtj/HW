package com.zhw1

/**
 * Created by sfghjtj on 2018/4/8.
 */
fun main(args: Array<String>) {
    val a = SubClass1()
    a.setValue()
    a.print()

}

open class ParentClass(open var x: Int = 10){
    open protected fun setValue() {
        x=100
    }
}
class SubClass1:ParentClass(){
    override var x =20
    fun print() {
        println(x)
        println(super.x)
        super.setValue()
        println(x)
        println(super.x)
    }

    override public fun setValue() {
        x=200
    }
}
