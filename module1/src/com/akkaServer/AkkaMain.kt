package com.akkaServer

import akka.actor.ActorSystem
import akka.actor.Props
import com.typesafe.config.ConfigFactory

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
          port = "2555"
        }
      }
    }
"""))
    //一个actor作为一个服务对外提供工作！
    val actorRef= system.actorOf(Props.create(AkkademyDb::class.java), "akkademy-db")
    println(actorRef.path())
}