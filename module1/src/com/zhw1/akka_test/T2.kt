package com.zhw1.akka_test

import akka.actor.ActorRef
import java.io.BufferedReader
import java.lang.ref.WeakReference

/**
 * Created by sfghjtj on 2018/5/4.
 */
fun main(args: Array<String>) {
    val path ="akka://default/user/\$\$a"
    val ac =ActorSys.system.actorSelection(path)
    ac.tell(SetRequest("key", "value"), ActorRef.noSender())
}

