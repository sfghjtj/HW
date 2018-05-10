package com.akkaServer

import akka.actor.ActorSelection
import akka.actor.ActorSystem
import org.junit.Test

/**
 * Created by sfghjtj on 2018/5/10.
 */
class JClientTest{
    val client = JClient()
    @Test
    fun t1() {
       // client.set("name", "zhw")
//        println((client.get("name") as CompletableFuture).get())
//        client.set("name","zhw").handle { t, u ->
//            if (u != null) {
//                println("error::"+u.message)
//            }else{
//                println(t)
//            }
//        }
        println(client)
    }

}