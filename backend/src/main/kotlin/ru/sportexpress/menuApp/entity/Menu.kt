package ru.sportexpress.menuApp.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import ru.sportexpress.menuApp.enums.SortType
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@NoArgsConstructor
@Table(name = "menu")
@EntityListeners(AuditingEntityListener::class)
@Getter
@Setter
@JsonIgnoreProperties(value = ["createdAt", "updatedAt"],
        allowGetters = true)
class Menu(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,

        @NotBlank
        @Column(name = "title")
        var title: String,

        @NotBlank
        @Column(name = "active")
        var active: Boolean,

        @Column(name = "weight")
        var weight: Float,

        @NotBlank
        @Column(name = "linkUrl")
        var linkUrl: String?,

        @NotBlank
        @Column(name = "parent_id")
        var parentId: Int?,

        @JsonIgnore
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "parent_id", insertable = false, updatable = false)
        var child: Menu?,

        @OneToMany(mappedBy = "child", cascade = [CascadeType.ALL])
        var children: Set<Menu>?,

        @JsonIgnore
        @Enumerated(EnumType.STRING)
        var sortType: SortType?,

        @Column(nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        var createdAt : Date,

        @Column(nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        var updatedAt : Date



)




