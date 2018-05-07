package com.zhw1.s1.s61

import org.w3c.dom.css.Rect
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.*

/**
 * Created by sfghjtj on 2018/4/13.
 */
fun main(args: Array<String>) {

    val c1=Int::class
    val c2 = Persons("zhw", 23)::class
//    println(c1.simpleName)
//    println(c1.qualifiedName)
//    println(c1.isAbstract)
//        c2.members.forEach { println(it.name) }
//  c2.functions.first().let { println(it.call(Persons("null",44),1,2))}
//    println(Persons::add.call(Persons("df",3),3,4))
//    c1.superclasses.forEach { println(it.qualifiedName) }
    val clz:KClass<Rectan> = Rectan::class
    //clz.constructors.forEach { println(it.toString()) }
    val rec = clz.primaryConstructor?.call(23, 45)
    val cons = clz.constructors.first()
   // println(clz.functions.first().parameters.size)
//    val rec2 = when (cons.parameters.size) {
//        3 -> cons.call(12,22,33)
//        2 -> cons.call(12,33)
//        1 -> cons.call(44)
//   //     else -> println("error!!!!")
//    }
   // println(rec2)
    val a: (Int) -> Rectan =::Rectan
    //println(a)
    val cls=Persons::class
    //cls.memberProperties.forEach { println(it) }
    val perc=::Persons
    val p = perc("zhw", 34)
    //println(cls.memberProperties.first().get(p))
    val c=Persons::name
    //println(c.get(p))
}

object AOB{
    override fun toString(): String = this.toString()
}

class Rectan(var width: Int, var height: Int){

    var area: Int
    init {
        area = width * height
    }
    constructor(width: Int,height: Int,area: Int):this(width,height){
        this.area = area
    }

    constructor(area: Int) : this(200, 200, area){
        this.area=area
    }

    override fun toString() = "Reactangle{width=$width,height=$height,area=$area}"

}


class Persons(var name: String, var age: Int){
    override fun toString(): String {
        return "Person{name=$name,age=$age}"
    }

    fun setNameAndage(name: String, age: Int) {
        this.name=name
        this.age=age
    }
}

fun add(a: Int,b: Int)=a+b
fun sub(a: Int,b: Int)=a-b
fun cal(opt: Char)=if('+'==opt) ::add else ::sub


inline fun <T,R> T.apply2(block: T.() -> R): T {
    this.block()
    return this
}