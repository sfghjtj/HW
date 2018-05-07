package com.zhw1.s1.s51

import com.alibaba.fastjson.JSON
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    println(EE.OPEN_ID.name.toLowerCase())
    val url="http://msdktest.qq.com/auth/verify_login?timestamp=1478745715&appid=100703379&sig=3f046b1cdd74e44f2832c1000e11119f&openid=A3284A812ECA15269F85AE1C2D94EB37&encode=2"

    val param = "appid=wxcde873f99466f74a&openid=oyQmcwlfqLdebciSJTiGy8Bm5N40&accessToken=u2OLuoBXgeJpL206s4Y6l1gb6vQDpL6dopCN9VGTUv7GRjUvxgxXT78Mxj-1SdYeRUObVB1FFbugXCpwYG_EPyKy0-HEnu6d861OB-xoVA8"+
            "&platform=desktop_m_wx&regChannel=2002&os=android&installchannel=73213123&offerid=1104674695"
    val mp= hashMapOf<String,String>("appid" to "100703379","openid" to "A3284A812ECA15269F85AE1C2D94EB37","openkey" to "933FE8C9AB9C585D7EABD04373B7155F",
            "userip" to "192.168.5.114")
    val s = JSON.toJSONString(mp)

//    URL(url).openStream().use { sis->
//        sis.bufferedReader().forEachLine {
//            println(it)
//        }
//    }
    var conn: HttpURLConnection? = null

    try {
        conn = URL(url).openConnection() as HttpURLConnection
        conn.doOutput = true
        conn.doInput=true
        DataOutputStream(conn.outputStream).use { dos->
            dos.write(s.toByteArray(Charsets.UTF_8))
        }
        conn.connect()
        println(conn.responseMessage)
        conn.inputStream.use { input ->
            println(input.bufferedReader().readText())
        }
        conn.disconnect()
    } catch (e: Exception) {
        e.printStackTrace()
    }finally {
        conn?.disconnect()
    }
}
enum class EE{
    OPEN_ID,VERSION,
}