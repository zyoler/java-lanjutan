package org.neophyte.pertemuan1.model;

import javafx.print.Collation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_category;

    @Column(name="category")
    private String category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_parent")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Collection<Category> children;

    @ManyToMany(mappedBy = "categories")
    private Collection<Book> books;

}
