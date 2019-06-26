package ru.sportexpress.menuApp.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import ru.sportexpress.menuApp.entity.Menu;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "menu", viewName = "all")
public interface MenuRepository extends CouchbaseRepository<Menu, Integer> {

}
