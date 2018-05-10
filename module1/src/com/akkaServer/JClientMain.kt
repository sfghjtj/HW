package com.akkaServer

import akka.actor.ActorSelection
import akka.actor.ActorSystem
import akka.actor.TypedActor.context
import akka.pattern.Patterns
import com.typesafe.config.ConfigFactory
import scala.compat.java8.FutureConverters
import java.util.concurrent.CompletableFuture

/**
 * Created by sfghjtj on 2018/5/10.
 */
fun main(args: Array<String>) {
    ActorSystem.create("LocalSystem", ConfigFactory.parseString("""
    akka {
     actor {
        provider = "akka.remote.RemoteActorRefProvider"
      }
    }
"""))
    var remoteDb: ActorSelection = context().actorSelection("akka.tcp://akkademy@$127.0.0.1:2555/user/akkademy-db")
    println(remoteDb.path())
    (FutureConverters.toJava(Patterns.ask(remoteDb,
            SetRequest("name", "zhw"), 200000)) as CompletableFuture<Any>).handle { t, u ->
        if (u != null) {
                println("error::"+u.message)
            }else{
            println(t)
        }
    }


}