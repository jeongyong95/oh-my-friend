package com.joojeongyong.ohmyfriend.common

import java.time.LocalDateTime
import java.time.ZoneId

class DateUtil {
    fun getEpochMilli(target: LocalDateTime): Long {
        return target.atZone(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli();
    }
}