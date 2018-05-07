package com.zhwlearn

/**
 * Created by sfghjtj on 2018/4/3.
 */
class User {
    var userName: String?
    var password: String?
    //由此说明kotlin会提供默认主构造函数的。public constructor()
    init {
        userName = null
        password = null

    }
}