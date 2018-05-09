package com.zhw1.akka_test

import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.Patterns
import akka.util.Timeout
import com.zhw1.akka_test.ActorSys.system
import scala.compat.java8.FutureConverters.toJava
import java.util.concurrent.CompletionStage
import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/5/7.
 */

object ActorSys{
    val system: ActorSystem = ActorSystem.create()
}

@Suppress("UNCHECKED_CAST")
fun askPong(message: String): CompletionStage<String> {
    val actorRef = system.actorOf(Props.create(PongActor::class.java))
    val future = Patterns.ask(actorRef, message, Timeout(5, TimeUnit.SECONDS))
    return toJava(future) as CompletionStage<String>
}
