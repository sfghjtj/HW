package com.zhw1.s1.s51

import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.ServerSocket
import java.net.Socket

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    ServerSocket(8080).use { server ->
        server.accept().use { socket ->
            BufferedInputStream(socket.getInputStream()).use { fis->
                FileOutputStream("module1/date4.txt").use { fos->
                    fis.copyTo(fos)
                    println("over!!")

                }
            }
        }

    }
}