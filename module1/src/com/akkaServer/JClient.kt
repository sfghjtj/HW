package com.akkaServer

import akka.actor.ActorSelection
import akka.actor.ActorSystem
import akka.actor.Status
import akka.pattern.Patterns
import com.typesafe.config.ConfigFactory
import scala.compat.java8.FutureConverters.toJava
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

/**
 * Created by sfghjtj on 2018/5/10.
 */
class JClient{
    val system = ActorSystem.create("LocalSystem", ConfigFactory.parseString("""
    akka {
     actor {
        provider = "akka.remote.RemoteActorRefProvider"
      }
      remote {
        netty.tcp {
          hostname = "127.0.0.1"
          port = "2554"
        }
      }
    }
"""))
    var remoteDb: ActorSelection? = null

    //remote address: 127.0.0.1:2552
    constructor(adress: String = "127.0.0.1:2555"){
        remoteDb = system.actorSelection("akka.tcp://akkademy@$adress/user/akkademy-db")
        println(remoteDb)
    }

    fun set(key: String, value: Any):CompletableFuture<Any> {
        return toJava(Patterns.ask(remoteDb, SetRequest(key, value),200000)) as CompletableFuture<Any>

    }

    fun get(key: String): CompletableFuture<Any> {
        return toJava(Patterns.ask(remoteDb,GetRequest(key),200000)) as CompletableFuture<Any>
    }

}