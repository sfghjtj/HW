package com.zhw1.akka_test

import akka.actor.AbstractActor
import akka.event.Logging
import akka.event.LoggingAdapter
import akka.japi.pf.FI
import akka.japi.pf.ReceiveBuilder

/**
 * Created by sfghjtj on 2018/5/4.
 */
class AkkadeMyDb: AbstractActor() {
    override fun createReceive(): Receive {
        return ReceiveBuilder().match(SetRequest::class.java, FI.UnitApply {
            log.info("recieve Set Request: {}", it)
            map.put(it.key,it.value)
        }).matchAny {
            log.info("receive unknown message:{}",it)
        }.build()
    }

    val log: LoggingAdapter = Logging.getLogger(context().system(), this)
    val map: HashMap<String, Any> = HashMap()

}
data class SetRequest(val key: String, val value: Any)


