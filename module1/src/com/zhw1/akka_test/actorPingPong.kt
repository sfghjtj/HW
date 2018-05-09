package com.zhw1.akka_test

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Status
import akka.japi.pf.FI
import akka.japi.pf.ReceiveBuilder

/**
 * Created by sfghjtj on 2018/5/4.
 */

class PongActor: AbstractActor(){
    override fun createReceive(): Receive {
        return ReceiveBuilder().matchEquals("ping", FI.UnitApply {
            //Thread.sleep(5000)
            sender().tell("pong", ActorRef.noSender())
        }).matchAny {
            sender().tell(Status.Failure(RuntimeException("unknown message!!")), self())
        }.build()
    }
}