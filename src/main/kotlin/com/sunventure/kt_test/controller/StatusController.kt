package com.sunventure.kt_test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.web.bind.annotation.PathVariable

@RestController
class IpStatusController {

    private val objectMapper = ObjectMapper()

    @GetMapping("/ip-status")
    fun getIpStatus(): ResponseEntity<Map<String, Any>> {

        val httpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://ifconfig.me/all.json"))
            .build()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        val responseBody: Map<String, Any> = objectMapper.readValue(response.body())

        val outputRes = mapOf(
            "ip" to responseBody,
            "status" to "ok"
        )
        return ResponseEntity.ok(outputRes)
    }

    @GetMapping("/hello", "/hello/{name}")
    fun hello(@PathVariable(required = false) name: String? = null): String {
        if (name == null) {
            return "Hello, World!"
        }
        return "Hello, $name!"
    }
}
