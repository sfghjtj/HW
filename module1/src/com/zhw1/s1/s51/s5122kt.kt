package com.zhw1.s1.s51

import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

/**
 * Created by sfghjtj on 2018/4/12.
 */
fun main(args: Array<String>) {
    DatagramSocket().use { socket->
        BufferedInputStream(FileInputStream("module1/date.txt")).use { fis->
            val addr = InetAddress.getByName("localhost")
            val byteArray = ByteArray(1024)
            var len=fis.read(byteArray)
            while (len>0) {
                val pack = DatagramPacket(byteArray, len,addr,8080)
                socket.send(pack)
                len=fis.read(byteArray)
            }
            val pack = DatagramPacket("bye".toByteArray(), 3, addr, 8080)
            socket.send(pack)
            println("send success!!!")
        }
    }
}