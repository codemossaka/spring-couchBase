package ru.sportexpress.menuApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sportexpress.menuApp.entity.Menu;
import ru.sportexpress.menuApp.repository.MenuRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MenuAppApplication {

    @Autowired
    MenuRepository menuRepository;
//
//    @PostConstruct
//    public void init() {
//        menuRepository.saveAll(Stream.of(
//                new Menu("1111", "John","/new", "fff",
//                        Arrays.asList(new Menu[]{new Menu("231", "ggg", "/new", "gggg", Arrays.asList(new Menu[] {}))})),
//                new Menu("2344", "ggg","/dnghn", "gggg", Arrays.asList(new Menu[] {})),
//                new Menu("355", "tdyj","/yjy", "errt", Arrays.asList(new Menu[] {})),
//                new Menu("46", "djyj","/jytjyj", "hrth", Arrays.asList(new Menu[] {})),
//                new Menu("46464", "yjky","/jyjyj", "hhhhrh", Arrays.asList(new Menu[] {})),
//                new Menu("555", "ggg","/jyjyj", "trh", Arrays.asList(new Menu[] {})),
//                new Menu("4346", "fmffm","/ye", "drth", Arrays.asList(new Menu[] {})),
//                new Menu("888", "hluilui","/dnjyty", "fdyj", Arrays.asList(new Menu[] {})),
//                new Menu("577", "gfrtrh","/new", "yjyjy", Arrays.asList(new Menu[] {})),
//                new Menu("777", "gfhdhtrh","/dnhn", "gfdh", Arrays.asList(new Menu[] {}))
//        ).collect(Collectors.toList()));
//    }

    public static void main(String[] args) {
        SpringApplication.run(MenuAppApplication.class, args);
    }

}
