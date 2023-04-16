package com.pawga777.ssldemo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * Created by sivannikov on 11.04.2023 10:18
 */

@RestController
class GreetingController {
    @GetMapping("/say-hello")
    fun sayHello(@RequestParam(name = "username", defaultValue = "World") username: String): String {
        return "Hello $username"
    }

    @GetMapping("/")
    fun hello(): String {
        return "Hello!"
    }
}