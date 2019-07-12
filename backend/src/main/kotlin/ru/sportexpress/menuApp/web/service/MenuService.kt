package ru.sportexpress.menuApp.web.service

import org.springframework.http.ResponseEntity
import ru.sportexpress.menuApp.entity.Menu
import ru.sportexpress.menuApp.requests.MenuResponse
import java.util.*


public interface MenuService {
    fun getAll(): MenuResponse

    fun getOne(id : Long): Optional<Menu>

    fun update(id : Long, customer : Menu):Menu

    fun save(customer : Menu):Menu

    fun delete(id : Long): ResponseEntity<*>
}
