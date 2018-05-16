package com.akkaServer

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Status
import akka.actor.TypedActor
import akka.event.Logging
import akka.event.LoggingAdapter
import akka.japi.pf.FI
import akka.japi.pf.ReceiveBuilder

/**
 * Created by sfghjtj on 2018/5/9.
 */
class AkkademyDb : AbstractActor() {

    val map: HashMap<String, Any> = HashMap()
    val log: LoggingAdapter = Logging.getLogger(context().system(), this)


    override fun createReceive(): Receive {
        val actorSender: ActorRef = this.sender()
        return ReceiveBuilder().match(SetRequest::class.java, FI.UnitApply {
            log.info("Received Set Request:{}",it)
            map.put(it.key,it.value)
            actorSender.tell(Status.Success(it.key), this.self())
        }).match(GetRequest::class.java, FI.UnitApply {
            log.info("Received Get Request:{}",it)
            actorSender.tell(map[it.key] ?: KeyNotFoundException(it.key), self())
        }).matchAny {
            actorSender.tell(Status.Failure(ClassNotFoundException()),self())
        }.build()
    }
}