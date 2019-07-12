package ru.sportexpress.menuApp.web.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.sportexpress.menuApp.entity.Menu
import ru.sportexpress.menuApp.exceptions.ResourceNotFoundException
import ru.sportexpress.menuApp.repository.MenuRepository
import ru.sportexpress.menuApp.requests.MenuResponse
import ru.sportexpress.menuApp.requests.Status
import java.util.*


@Service
class MenuServiceImpl : MenuService {

    @Autowired
    lateinit var menuRepository: MenuRepository

    override fun getAll(): MenuResponse {
        val menuResponse = MenuResponse()
        menuResponse.status = Status.OK
        menuResponse.result = menuRepository.findAllByParentIdIsNull()
        return menuResponse
    }

    override fun getOne(id: Long): Optional<Menu> {
        return menuRepository.findById(id)
    }

    override fun update(id: Long, menu: Menu): Menu {
        val menu1: Menu = menuRepository.findById(id).orElseThrow { ResourceNotFoundException("Menu", "id", id) }
        menu1.title = menu.title
        menu1.linkUrl = menu.linkUrl
        menu1.active = menu.active
        menu1.parentId = menu.parentId
        menu1.weight = menu.weight
        menu1.sortType = menu.sortType
        menu1.parentId = menu.parentId
        menuRepository.save(menu1)
        return menu1
    }

    override fun save(menu: Menu): Menu {
        return menuRepository.save(menu)
    }

    override fun delete(id: Long): ResponseEntity<*> {
        val menu2: Menu = menuRepository.findById(id).orElseThrow { ResourceNotFoundException("Menu", "id", id) }
        menuRepository.delete(menu2)
        return ResponseEntity.ok().build<Any>()
    }

}
