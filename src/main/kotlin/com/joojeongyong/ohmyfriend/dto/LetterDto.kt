package com.joojeongyong.ohmyfriend.dto

import com.joojeongyong.ohmyfriend.domain.letter.Letter
import java.time.LocalDateTime

data class LetterDto(
    var letterId: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
) {
    companion object {
        fun from(letter: Letter): LetterDto {
            return LetterDto(letter.letterId, letter.title, letter.content, letter.createdAt, letter.updatedAt)
        }
    }
}