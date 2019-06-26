package ru.sportexpress.menuApp.service;

import ru.sportexpress.menuApp.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> getAll();

    Optional<Menu> getOne(Integer id);

    Menu update(int id, Menu customer);

    Menu save(Menu customer);

    Menu delete(int id);
}
