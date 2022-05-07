package com.joojeongyong.ohmyfriend.domain.letter

import com.joojeongyong.ohmyfriend.dto.LetterDto
import com.joojeongyong.ohmyfriend.dto.LetterRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LetterService(private val letterRepository: LetterRepository) {

    @Transactional(readOnly = false, timeout = 3)
    fun writeLetter(requestDto: LetterRequestDto): LetterDto {
        return LetterDto.from(letterRepository.save(Letter.from(requestDto)))
    }

    fun readLetter(letterId: Long): LetterDto {
        return LetterDto.from(letterRepository.findById(letterId).let { it.get() })
    }
}