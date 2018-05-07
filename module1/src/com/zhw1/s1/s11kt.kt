package com.zhw1.s1

/**
 * Created by sfghjtj on 2018/4/8.
 */
sealed class Result() {


    class Success(val message: String) : Result()
    class Failure(val error: String) : Result()
}
fun onResult(result: Result) {
    when (result) {
        is Result.Success -> println("success")
        is Result.Failure -> println("fail!")
    }
}