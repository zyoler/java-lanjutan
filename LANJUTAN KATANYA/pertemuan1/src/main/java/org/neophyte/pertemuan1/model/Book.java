package org.neophyte.pertemuan1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_book;

    @Column(name="title")
    private String title;

    @Column(name="isbn")
    private  String isbn;

    @Column(name="total_pages")
    private  int total_pages;

    @Column(name="rating")
    private int rating;

    @Column(name="published_date")
    private String published_date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_photo")
    private Photo photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_categories",
            joinColumns =@JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name="id_category")
    )

    private Collection<Category> categories;
}
