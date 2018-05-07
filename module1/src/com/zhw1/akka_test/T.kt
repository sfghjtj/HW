package com.zhw1.akka_test

import akka.actor.ActorRef
import akka.actor.Props
import akka.testkit.TestActorRef

/**
 * Created by sfghjtj on 2018/5/4.
 */
fun main(args: Array<String>) {
    var actorRef: TestActorRef<AkkadeMyDb> = TestActorRef.create(ActorSys.system, Props.create(AkkadeMyDb::class.java))
    actorRef.tell(SetRequest("key", "value"), ActorRef.noSender())
    println(actorRef.path())
}