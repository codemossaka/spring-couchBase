package ru.sportexpress.menuApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Table(name = "menu")
@Entity
@Getter
@Setter
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
    @Column(name = "parent_id")
    private Integer parentId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Menu child;

    @OneToMany(mappedBy = "child", cascade = {CascadeType.ALL})
    private Set<Menu> children;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private SortType sortType;

}

enum SortType {
    row,
    column
}