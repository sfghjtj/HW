package com.zhw1.akka_test

import akka.actor.ActorRef
import org.junit.Test
import java.util.concurrent.*

/**
 * Created by sfghjtj on 2018/5/4.
 */
class T2{

    @Test
    fun t1() {
        val path ="akka://default/user/\$\$a"
        val ac =ActorSys.system.actorSelection(path)
        ac.tell(SetRequest("key", "value"), ActorRef.noSender())
        Executors.newCachedThreadPool()
    }

    @Test
    fun t2() {
        val a = CompletableFuture.completedFuture("zhwdbg")
        println(a.get())
    }


    @Test
    fun t3() {
        val ft =FutureTask<String>(Callable {
            Thread.sleep(1000)
            "zhw"
        })
        Thread(ft).apply { start() }
        println(ft.get(5,TimeUnit.SECONDS))//阻塞
        println("zzzzzzz")
    }
}