package com.example.demo.models;

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
@Table(name ="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "total_pages")
    private Integer total_pages;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "published_date")
    private String published_date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="photo_id")
    private Photo photo;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name="books_categories",
            joinColumns = @JoinColumn(name = "bookd_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )private Collection<Category> categories;
}
