package com.zhw1.akka_test

import akka.actor.ActorRef
import org.junit.Test

/**
 * Created by sfghjtj on 2018/5/4.
 */
class T2{

    @Test
    fun t1() {
        val path ="akka://default/user/\$\$a"
        val ac =ActorSys.system.actorSelection(path)
        ac.tell(SetRequest("key", "value"), ActorRef.noSender())
    }
}