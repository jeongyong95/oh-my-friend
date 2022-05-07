package com.joojeongyong.ohmyfriend.api

import com.joojeongyong.ohmyfriend.domain.letter.LetterService
import com.joojeongyong.ohmyfriend.dto.LetterDto
import com.joojeongyong.ohmyfriend.dto.LetterRequestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/letter")
@RestController
class LetterController(
    private val letterService: LetterService
) {
    @PostMapping
    fun writeLetter(@RequestBody requestDto: LetterRequestDto): LetterDto {
        return letterService.writeLetter(requestDto)
    }

    @GetMapping("{letterId}")
    fun readLetter(@PathVariable(required = true) letterId: Long): ResponseEntity<LetterDto> {
        return ResponseEntity.ok(letterService.readLetter(letterId))
    }
}