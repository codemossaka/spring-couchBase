package ru.sportexpress.menuApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.sportexpress.menuApp.entity.Menu;

import java.util.List;

//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc = "menu", viewName = "all")
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.parentId is Null")
    List<Menu> findAll();
}
