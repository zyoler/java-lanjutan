package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer photo_id;

    @Column(name = "url_small")
    private Integer url_small;

    @Column(name = "url_medium")
    private Integer url_medium;

    @Column(name = "url_large")
    private Integer url_large;

    @OneToOne(mappedBy = "photo")
    private Book book;
}

