package com.airwallex.infra.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserLogin {
    @GetMapping("/wrong")
    fun wrong(@RequestParam("userId") userId: Int): Map<String, String> {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        val before = Thread.currentThread().name + ":" + currentUser.get()
        //设置用户信息到ThreadLocal
        currentUser.set(userId)
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        val after = Thread.currentThread().name + ":" + currentUser.get()
        //汇总输出两次查询结果
        val result: MutableMap<String, String> = HashMap()
        result["before"] = before
        result["after"] = after
        return result
    }

    companion object {
        private val currentUser = ThreadLocal.withInitial<Int> { null }
    }
}