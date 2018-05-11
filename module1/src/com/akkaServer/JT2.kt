package com.akkaServer

import akka.actor.ActorSelection
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.Patterns
import akka.util.Timeout
import org.junit.Ignore
import org.junit.Test
import scala.compat.java8.FutureConverters
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/5/10.
 */
class JClientTest{
    val client = JClient()
    @Test


    fun t1() {
        client.set("name","zhw").whenComplete { t, u ->
           if (u != null) {
               println("error::"+u.message)
           }else{
               println(t)
           }
       }
    }

}