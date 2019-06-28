package ru.sportexpress.menuApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sportexpress.menuApp.entity.Menu;

//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc = "menu", viewName = "all")
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
