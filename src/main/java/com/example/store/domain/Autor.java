package com.example.store.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String firstName;

    @Column(nullable = false, length = 45)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "id_autor")
    private Set<Carte> carti = new HashSet<>();

    public Autor(){}

    public Autor(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id_autor) {
        this.id = id_autor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Carte> getBooks() {
        return carti;
    }

    public void setBooks(Set<Carte> carti) {
        this.carti = carti;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String autorName(){
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autor autor = (Autor) o;

        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
