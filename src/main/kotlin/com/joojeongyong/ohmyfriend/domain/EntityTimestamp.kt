package com.joojeongyong.ohmyfriend.domain

import java.time.LocalDateTime

interface EntityTimestamp {
    var createdAt: LocalDateTime?
    var updatedAt: LocalDateTime?
}