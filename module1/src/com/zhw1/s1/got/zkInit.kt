package com.zhw1.s1.got

import com.alibaba.fastjson.JSON
import org.apache.curator.framework.CuratorFramework
import org.apache.curator.framework.CuratorFrameworkFactory
import org.apache.curator.retry.ExponentialBackoffRetry

/**
 * Created by sfghjtj on 2018/5/2.
 */

fun main(args: Array<String>) {

//    createRedisNode()
//    updateTencentAuthURl()
//    updateRedisSourceConfig()
   val b = zkClient.data.forPath("/got/tencent_auth_urls")
    val c: ZkTencentAuthURLConfig = JSON.parseObject(b, ZkTencentAuthURLConfig::class.java)
    println(c)

}

val zkClient: CuratorFramework = CuratorFrameworkFactory.newClient("10.7.80.28:2181",ExponentialBackoffRetry(100,33)).apply { start() }

private fun createRedisNode() {
    zkClient.create().forPath("/got/redis_ds")
}

private fun updateTencentAuthURl() {
    val authUrl = ZkTencentAuthURLConfig()
    zkClient.setData().forPath("/got/tencent_auth_urls",JSON.toJSONBytes(authUrl))
}

private fun updateRedisSourceConfig() {
    val config = ZkCacheDataSourceConfigList()
    (0 until 10).mapTo(config.configList){
        ZkCacheDataSourceConfig().apply {
            shardId =it
            host ="127.0.0.1"
            port =6379
        }
    }
    zkClient.setData().forPath("/got/redis_ds", JSON.toJSONBytes(config))
}

data class ZkTencentAuthURLConfig(
        val qqAuthUrl: String = "http://msdktest.qq.com/auth/verify_login",
        val wxAuthUrl: String = "http://msdktest.qq.com/auth/check_token",
        val guestAuthUrl: String = "http://msdktest.qq.com/auth/guest_check_token",
        val getPfAndPfKeyUrl: String ="http://msdktest.qq.com/auth/get_pfval",
        val getQQPersonalInfo: String ="http://msdktest.qq.com/relation/qqprofile",
        val getWXPersonalInfo: String ="http://msdktest.qq.com/relation/wxuserinfo"
)
data class ZkCacheDataSourceConfigList(
        val configList: ArrayList<ZkCacheDataSourceConfig> = ArrayList()
)

class ZkCacheDataSourceConfig{
    var shardId: Int =-1
    lateinit var host: String
    var port: Int =6379
    var password: String? =null
}