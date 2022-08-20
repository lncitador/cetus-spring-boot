package com.pyxlab.cetus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CetusApplication

fun main(args: Array<String>) {
	runApplication<CetusApplication>(*args)
}
