package ru.sportexpress.menuApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Table(name = "menu")
@Entity
@Data
public class Menu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "link_url")
    private String link_url;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    private Menu child;

    @JsonIgnore
    @OneToMany(mappedBy = "child", cascade = {CascadeType.ALL})
    private Set<Menu> childreen;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private SortType sortType;

}

enum SortType {
    row,
    column
}