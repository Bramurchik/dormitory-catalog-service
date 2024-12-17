package com.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DormitoryCatalogServiceApplication

fun main(args: Array<String>) {
    runApplication<DormitoryCatalogServiceApplication>(*args)
}
