package com.zhw1.s1.s51

import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    DatagramSocket(8080).use { socket->
        BufferedOutputStream(FileOutputStream("module1/date6.txt")).use { fos->
            val byteArray = ByteArray(1024)
            val data = DatagramPacket(byteArray, byteArray.size)
            while(true){
                socket.receive(data)
                if (data.length == 3) {
                    if("bye"== String(byteArray,0,3)) break
                }
                fos.write(byteArray,0,data.length)
            }
            println("receive success!")

        }
    }
}