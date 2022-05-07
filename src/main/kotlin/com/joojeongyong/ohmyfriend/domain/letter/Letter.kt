package com.joojeongyong.ohmyfriend.domain.letter

import com.joojeongyong.ohmyfriend.domain.EntityTimestamp
import com.joojeongyong.ohmyfriend.domain.TimestampListener
import com.joojeongyong.ohmyfriend.dto.LetterRequestDto
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(TimestampListener::class)
@Table(name = "letter")
@Entity
class Letter(
    @Id
    @Column(name = "letter_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val letterId: Long? = null,

    @Column(name = "title", length = 50)
    var title: String? = null,

    @Column(name = "content", columnDefinition = "TEXT")
    var content: String? = null,

    @Column(name = "created_at", updatable = false)
    override var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    override var updatedAt: LocalDateTime? = null
) : EntityTimestamp {

    companion object {
        fun from(requestDto: LetterRequestDto): Letter {
            return Letter(title = requestDto.title, content = requestDto.content)
        }
    }
}