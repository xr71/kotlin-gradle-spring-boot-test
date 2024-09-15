package com.sunventure.kt_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@SpringBootApplication
class KtTestApplication

fun main(args: Array<String>) {
	runApplication<KtTestApplication>(*args)
}

