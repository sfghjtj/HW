package com.zhw1.s1.s81

import com.alibaba.fastjson.JSON
import org.apache.commons.httpclient.NameValuePair
import org.apache.commons.httpclient.util.EncodingUtil
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

/**
 * Created by houwei on 2018/4/18.
 * HttpURLConnection的封装
 */


enum class HttpMethod {
    GET, POST,
}

// TODO 设置超时
private const val DEFAULT_TIMEOUT_MILLS = 3100


class GotResponse(val code: Int, val body: String) {
    val isSuccessful: Boolean
        get() = code in 200..299
}

class GotRequest private constructor(val url: String, val getParam: Map<String, Any>?, val postParam: Map<String, Any>?, val heads: Map<String, Any>?, val method: HttpMethod) {

    private lateinit var connection: HttpURLConnection

    private constructor(builder: Builder) : this(builder.url, builder.getParam, builder.postParam, builder.heads, builder.method)

    //TODO 发送异步消息
    //发送同步消息
    fun execute(): GotResponse {
        when (method) {
            HttpMethod.GET -> get()
            HttpMethod.POST -> post()
            else -> throw RuntimeException("request method error!")
        }
        return response(connection)
    }

    private fun get() {
        connection = URL(generateUrl(url)).openConnection() as HttpURLConnection
        connection.apply {
            requestMethod = HttpMethod.GET.name
            connectTimeout = DEFAULT_TIMEOUT_MILLS
            readTimeout = DEFAULT_TIMEOUT_MILLS
            doInput = true
            useCaches = false
            heads?.let {
                it.forEach {
                    this.setRequestProperty(it.key, it.value.toString())
                }
            }
        }
        connection.connect()

    }

    private fun post() {
        connection = URL(generateUrl(url)).openConnection() as HttpURLConnection
        connection.apply {
            requestMethod = HttpMethod.POST.name
            connectTimeout = DEFAULT_TIMEOUT_MILLS
            readTimeout = DEFAULT_TIMEOUT_MILLS
            doInput = true
            doOutput = true
            useCaches = false
            heads?.let {
                it.forEach {
                    this.setRequestProperty(it.key, it.value.toString())
                }
            }
        }
        connection.connect()
        //TODO  提交表单形式信息
        //json字符串提交
        postParam?.let {
            p ->
            DataOutputStream(connection.outputStream).use { it.write(JSON.toJSONString(p).toByteArray()) }
        }
    }

    private fun generateUrl(url: String): String {
        val nameValueArray = getParam?.let {
            it.map {
                NameValuePair(it.key, it.value.toString())
            }.toTypedArray()
        }
        return if (nameValueArray != null) url + "?" + EncodingUtil.formUrlEncode(nameValueArray, StandardCharsets.UTF_8.name()) else url
    }

    // 获取响应
    private fun response(connection: HttpURLConnection): GotResponse {
        return GotResponse(connection.responseCode, DataInputStream(connection.inputStream).bufferedReader().use { it.readText() }).also {
            connection.disconnect()
        }
    }


    companion object {
        fun build(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {
        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        lateinit var url: String
        var getParam: Map<String, Any>? = null
        var postParam: Map<String, Any>? = null
        var heads: Map<String, Any>? = null
        var method: HttpMethod = HttpMethod.GET

        fun url(init: Builder.() -> String) = apply { url = init() }
        fun getParam(init: Builder.() -> Map<String, Any>) = apply { getParam = init() }
        fun postParam(init: Builder.() -> Map<String, Any>) = apply { postParam = init() }
        fun heads(init: Builder.() -> Map<String, Any>) = apply { heads = init() }
        fun method(init: Builder.() -> HttpMethod) = apply { method = init() }

        fun build() = GotRequest(this)

    }


}

fun main(args: Array<String>) {
    val res=GotRequest.build {
        url = "http://msdktest.qq.com/auth/verify_login?timestamp=1478745715&appid=100703379&sig=3f046b1cdd74e44f2832c1000e11119f&openid=A3284A812ECA15269F85AE1C2D94EB37&encode=2"
        getParam = hashMapOf("timestamp" to "1478745715", "appid" to "100703379", "sig" to "3f046b1cdd74e44f2832c1000e11119f", "openid" to "A3284A812ECA15269F85AE1C2D94EB37", "encode" to "2")
        postParam { hashMapOf<String,String>("appid" to "100703379","openid" to "A3284A812ECA15269F85AE1C2D94EB37","openkey" to "933FE8C9AB9C585D7EABD04373B7155F",
                "userip" to "192.168.5.114") }
        method = HttpMethod.POST
    }.execute()
    println(res.code)
    println(if(res.isSuccessful) res.body else "error request!")

}


