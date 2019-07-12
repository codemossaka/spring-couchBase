package ru.sportexpress.menuApp.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.sportexpress.menuApp.entity.Menu
import ru.sportexpress.menuApp.requests.MenuResponse
import ru.sportexpress.menuApp.web.service.GraphQlService
import ru.sportexpress.menuApp.web.service.MenuService
import java.util.*
import javax.validation.Valid


@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    lateinit var menuService: MenuService 

    @Autowired
    lateinit var graphQLService :GraphQlService

    @GetMapping("/")
    fun getAll() : MenuResponse {
        return menuService.getAll()
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable("id") id : Long) : Optional<Menu> {
        return menuService.getOne(id)
    }

    @PostMapping("")
    fun saveCustomer(@Valid @RequestBody menu: Menu) : Menu{
        return menuService.save(menu)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable(name = "id") id :Long, @Valid @RequestBody customer:Menu):Menu {
        return menuService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable(name = "id") id :Long):Menu {
        return menuService.delete(id)
    }

//    @GetMapping("/swithParent")
//    fun changeParent(@PathParam("data") params : Map<String, Long> ):Menu{
//        return null
//    }
//
//    @PostMapping("/graphql")
//    fun getAllCustomers(@RequestBody query : String) :ResponseEntity<Objects> {
//        val execute : ExecutionResult = graphQLService.getGraphQL().execute(query)
//        return ResponseEntity<>(execute, HttpStatus.OK)
//    }
}
