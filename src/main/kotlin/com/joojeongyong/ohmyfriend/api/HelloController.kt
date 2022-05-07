package com.joojeongyong.ohmyfriend.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping(value = ["hello"])
    fun hello(): String {
        return "hello"
    }

}