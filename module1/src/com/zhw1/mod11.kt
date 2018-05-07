package com.zhw1

/**
 * Created by sfghjtj on 2018/4/4.
 */

fun main(args: Array<String>) {
    UserDao.create()
    UserDao.findAll()
    println(UserDao.Singleton.x)
    println(DAOUtil.getNow())
}
interface DaoInterface{
    fun create(): Int
    fun findAll(): Array<Any>?

}
object UserDao: DaoInterface{
    private var datas: Array<Any>? = null

    override fun create(): Int {
        return 0

    }

    override fun findAll(): Array<Any>? {
        return datas
    }

    object Singleton{
        val x=10
    }
}
class Outerr{
    object Singleton{
        val x=10
    }
}