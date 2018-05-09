package com.zhw1.sigartest

import org.hyperic.sigar.Sigar

/**
 * Created by sfghjtj on 2018/5/9.
 */
fun main(args: Array<String>) {
    val sigar = Sigar()
    val mem = sigar.mem
    println("内存总量：${mem.total / 1024L}")
    println("当前内存使用量：${mem.used / 1024L}")
    println("当前内存剩余量：${mem.free / 1024L}")
    var infos = sigar.cpuInfoList
    var cpuList = sigar.cpuList
    println(infos.first().mhz)
    println(infos.first().vendor)
}