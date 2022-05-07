package com.joojeongyong.ohmyfriend.cache

import org.springframework.data.repository.CrudRepository

interface UserCacheRepository : CrudRepository<UserCache, Long> {
}