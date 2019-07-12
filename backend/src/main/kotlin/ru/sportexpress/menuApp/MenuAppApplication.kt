package ru.sportexpress.menuApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class MenuAppApplication

fun main(args: Array<String>) {
	runApplication<MenuAppApplication>(*args)
}
