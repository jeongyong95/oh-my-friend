package com.joojeongyong.ohmyfriend.cache

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "user", timeToLive = 10 * 60)
data class UserCache(
    @Id
    var userId: Long? = null,
    var userName: String? = null,
    var email: String? = null,
    var password: String? = null
) {
}