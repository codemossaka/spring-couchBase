package ru.sportexpress.menuApp.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Document
public class Menu {

    @Id
    @Setter
    @Getter
    private String id;

    @Field
    @Setter
    @Getter
    private String name;

    @Field
    @Setter
    @Getter
    private String link;

    @Field(value = "short_link")
    @Setter
    @Getter
    private String shortLink;

    @Field
    @Setter
    @Getter
    private String parent;

    @Field
    @Getter
    private List<Menu> chidlreen;


    public void setChidlreen(List<Menu> chidlreen) {
        this.chidlreen = chidlreen;
        chidlreen.forEach( menu -> menu.setParent(this.id));
    }

    public Menu(String id, String name, String link, String shortLink, List<Menu> chidlreen) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.shortLink = shortLink;
        setChidlreen(chidlreen);
    }



    public void addChild(Menu child){

        if (chidlreen!= null){
            chidlreen = new ArrayList<>();
        }
        chidlreen.add(child);
    }
}
