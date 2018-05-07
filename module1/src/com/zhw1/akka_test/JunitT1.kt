package com.zhw1.akka_test

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.Patterns
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.zhw1.akka_test.ActorSys.system
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import scala.compat.java8.FutureConverters.toJava
import scala.concurrent.Await
import scala.concurrent.Future
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit

/**
 * Created by sfghjtj on 2018/5/4.
 */

object ActorSys{
    val system: ActorSystem = ActorSystem.create()
}

class AkkademyDbTest{

    var actorRef:TestActorRef<AkkadeMyDb>?  =null

    @Before
    fun initActor() {
        actorRef = TestActorRef.create(ActorSys.system, Props.create(AkkadeMyDb::class.java))
    }

    @Test
    @Ignore
    fun testReceive() {
        val actorRef: TestActorRef<AkkadeMyDb> = TestActorRef.create(ActorSys.system, Props.create(AkkadeMyDb::class.java))
        actorRef.tell(SetRequest("key", "value"), ActorRef.noSender())
        val akkde: AkkadeMyDb = actorRef.underlyingActor()
        println(actorRef.path())
        println(akkde.map["key"] == "value")
    }

    @Test
    fun testPongActor() {
        val actorRef = system.actorOf(Props.create(PongActor::class.java))
        val future = Patterns.ask(actorRef, "ping", 5)
        val a =Await.result(future, Timeout(5, TimeUnit.SECONDS).duration()) //等同于java8的CompletableFuture.get()的阻塞。
        println(a)
    }

    @Test
    fun testPongJavaActor() {
        val actorRef = system.actorOf(Props.create(PongActor::class.java))
        val future: Future<Any> = Patterns.ask(actorRef, "ping", 5L)
        val cs: CompletionStage<Any> = toJava(future)
        @Suppress("UNCHECKED_CAST")
        val ft: CompletableFuture<String> = cs as CompletableFuture<String>
        //println(ft.get(1000, TimeUnit.MILLISECONDS))
        ft.thenCompose { it ->
            CompletableFuture.completedFuture(it)
        }.handle { t, u ->
            if (u != null) {
                println(u)
            } else {
                println(t)
            }
        }
       println("over!!!!!")
    }

}