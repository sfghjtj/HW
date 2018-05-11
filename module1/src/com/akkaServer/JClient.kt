package com.akkaServer

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.actor.ActorSystem
import akka.actor.Status
import akka.actor.TypedActor.context
import akka.pattern.Patterns
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import scala.compat.java8.FutureConverters.toJava
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/5/10.
 */
class JClient{
    val system = ActorSystem.create("LocalSystem")
    var remoteDb: ActorRef?=null

    //remote address: 127.0.0.1:2552
    constructor(adress: String = "127.0.0.1:2555"){
        remoteDb = system.actorFor("""akka.tcp://akkademy@$adress/user/akkademy-db""")
        println(remoteDb)
    }

    fun set(key: String, value: Any):CompletableFuture<Any> {
        return toJava(Patterns.ask(remoteDb, SetRequest(key, value), Timeout(5,TimeUnit.MINUTES))) as CompletableFuture<Any>

    }


    fun get(key: String): CompletableFuture<Any> {
        return toJava(Patterns.ask(remoteDb,GetRequest(key),Timeout(5,TimeUnit.MINUTES))) as CompletableFuture<Any>
    }

}