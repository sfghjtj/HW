package com.zhw1.akka_test

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.testkit.TestActorRef
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

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
        //val actorRef = system.actorOf(Props.create(PongActor::class.java))
        val path ="akka://default/user/\$\$a"
        //val ac =system.actorSelection(actorRef?.path()?.toSerializationFormat())
        //ac.tell(SetRequest("key", "value"), ActorRef.noSender())
        println(actorRef?.path())
    }

}