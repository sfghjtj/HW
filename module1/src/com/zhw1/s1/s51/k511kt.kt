package com.zhw1.s1.s51

import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.net.Socket

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    Socket("127.0.0.1",8080).use {socket->
        BufferedOutputStream(socket.getOutputStream()).use { bos->
            FileInputStream("module1/date.txt").use { fis->
                fis.copyTo(bos)
                println("up over!")
            }
        }
    }
}