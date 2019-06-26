package ru.sportexpress.menuApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sportexpress.menuApp.entity.Menu;
import ru.sportexpress.menuApp.repository.MenuRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAll() {


        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getOne(Integer id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu update(int id, Menu menu) {
        Menu menu1 = menuRepository.findById(id).orElse(null);
        if (menu1 == null) {
            return null;
        }
        menu1.setName(menu.getName());
        menu1.setLink(menu.getLink());
        menu1.setShortLink(menu.getShortLink());
        menuRepository.save(menu1);
        return menu1;
    }

    @Override
    public Menu save(Menu menu) {
        Menu menu1 = menuRepository.save(menu);
        return menu1;
    }

    @Override
    public Menu delete(int id) {
        Menu menu2 = menuRepository.findById(id).orElse(null);
        if (menu2 == null) {
            return null;
        }
        menuRepository.delete(menu2);
        return null;
    }
}
