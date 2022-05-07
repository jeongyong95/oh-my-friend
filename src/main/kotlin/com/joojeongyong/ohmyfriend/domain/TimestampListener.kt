package com.joojeongyong.ohmyfriend.domain

import java.time.LocalDateTime
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

class TimestampListener {
    @PrePersist
    fun prePersist(entity: Any) {
        val now: LocalDateTime = LocalDateTime.now()
        if (entity is EntityTimestamp) {
            entity.createdAt = now
            entity.updatedAt = now
        }
    }

    @PreUpdate
    fun preUpdate(entity: Any) {
        val now: LocalDateTime = LocalDateTime.now()
        if (entity is EntityTimestamp) {
            entity.updatedAt = now
        }
    }
}