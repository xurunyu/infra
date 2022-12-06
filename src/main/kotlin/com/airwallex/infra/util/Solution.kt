package com.airwallex.infra.util

object Solution {
    fun canJump(nums: IntArray): Boolean {
        var temp: Int = 0
        nums.forEachIndexed { index, i ->
            if(index <= temp) {
                temp = temp.coerceAtLeast(index + i)
            }
            if(temp >= nums.size) {
                return true
            }
        }
        return temp >= nums.size
    }
}