package ru.sportexpress.menuApp.web.service.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sportexpress.menuApp.entity.Menu;
import ru.sportexpress.menuApp.repository.MenuRepository;

import java.util.List;

@Component
public class AllMenuDataFetcher implements DataFetcher<List<Menu>> {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return (List<Menu>) menuRepository.findAll();
    }
}
