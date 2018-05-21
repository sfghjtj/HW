package com.akkaServer

import com.algorithm.zhw.PartitionHash
import java.util.concurrent.CompletableFuture

/**
 * Created by sfghjtj on 2018/5/18.
 */
fun main(args: Array<String>) {

    val partKey: Int = 12
    val machineNum: Int = 4
    println(PartitionHash.conHashPartionToArea(partKey,machineNum))


}
