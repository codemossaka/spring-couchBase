package ru.sportexpress.menuApp.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.sportexpress.menuApp.entity.Menu


interface MenuRepository : JpaRepository<Menu, Long> {

//    @Query("SELECT m FROM Menu m WHERE m.parentId is Null")
    fun findAllByParentIdIsNull(): List<Menu>
}
