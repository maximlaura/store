package com.example.store.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@DynamicUpdate(true)
//@Table(name = "carte")
public class Carte {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String title;

    @Column(nullable = false, length = 45)
    private String isbn;

    @ManyToOne
    private Editura editura;

    @Column(length = 10)
    private Integer year;

    @Column(nullable = false, length = 25)
    private Float price;

    @ManyToOne
    private Autor autor;

    @Column()
    private String bookPic;

    public Carte() {
    }

    public Carte(String title, String isbn){
        this.isbn=isbn;
        this.title=title;
    }

    public Carte(String title, String isbn, Editura editura, Integer year, Float price, Autor autor, String bookPic) {
        this.title = title;
        this.isbn = isbn;
        this.editura = editura;
        this.year = year;
        this.price = price;
        this.autor = autor;
        this.bookPic = bookPic;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carte carte = (Carte) o;

        return Objects.equals(id, carte.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
