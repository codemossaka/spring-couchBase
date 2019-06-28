package ru.sportexpress.menuApp.web.controller;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sportexpress.menuApp.entity.Menu;
import ru.sportexpress.menuApp.web.service.MenuService;
import ru.sportexpress.menuApp.web.service.GraphQlService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    private MenuService menuService;

    @Autowired
    GraphQlService graphQLService;

    @GetMapping(value = "")
    public List<Menu> getAll() {
        return menuService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Menu> getCustomer(@PathVariable("id") int id) {
        return menuService.getOne(id);
    }

    @PostMapping(value = "")
    public Menu saveCustomer(@RequestBody Menu customer) {
        return menuService.save(customer);
    }

    @PutMapping(value = "/{id}")
    public Menu updateCustomer(@PathVariable(name = "id") int id, @RequestBody Menu customer) {
        return menuService.update(id, customer);
    }

    @DeleteMapping(value = "/{id}")
    public Menu deleteCustomer(@PathVariable(name = "id") int id) {
        return menuService.delete(id);
    }

    @PostMapping(value = "/graphql")
    public ResponseEntity<Object> getAllCustomers(@RequestBody String query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
