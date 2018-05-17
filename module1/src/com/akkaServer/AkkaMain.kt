package com.akkaServer

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.TypedActor.context
import akka.pattern.Patterns
import com.typesafe.config.ConfigFactory
import scala.compat.java8.FutureConverters.toJava
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by sfghjtj on 2018/5/10.
 */
//AkkademyDb作为服务端程序，启动服务器，不能将application.conf放在客户端！！
fun main(args: Array<String>) {
    val system: ActorSystem = ActorSystem.create("akkademy",ConfigFactory.parseString("""
     akka {
     actor {
        provider = "akka.remote.RemoteActorRefProvider"
      }
      remote {
        netty.tcp {
          hostname = "127.0.0.1"
          port = "26222"
        }
      }
    }
"""))

    //一个actor作为一个服务对外提供工作！
    val actorRef= system.actorOf(Props.create(AkkademyDb::class.java), "akkademy-db")
    println(actorRef.path())
    val a = toJava(Patterns.ask(actorRef, SetRequest("name", "zhw"), 2000)) as CompletableFuture

}



