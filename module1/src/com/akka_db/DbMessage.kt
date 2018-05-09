package com.akka_db

import java.lang.RuntimeException

/**
 * Created by sfghjtj on 2018/5/9.
 */
//注意消息始终是不可变的。
data class SetRequest(val key: String, val value: Any)
data class GetRequest(val key: String)
data class KeyNotFoundException(val key: String) : RuntimeException(key)


