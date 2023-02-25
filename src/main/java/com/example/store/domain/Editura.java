package com.example.store.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name = "editura")
public class Editura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    public String nume;

    @Column(nullable = false, length = 45)
    private String address;

    @Column(nullable = false, length = 15)
    private String city;

    @Column(nullable = false, length = 15)
    private String county;

    @Column(length = 15)
    private String code;

    @OneToMany
    @JoinColumn(name = "id_editura")
    private Set<Carte> carti = new HashSet<>();

    public Editura() {
    }

    public Editura(String nume, String address, String city, String county, String code) {
        this.nume = nume;
        this.address = address;
        this.city = city;
        this.county = county;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Editura{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Editura editura = (Editura) o;

        return Objects.equals(id, editura.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Set<Carte> getCarti() {
        return carti;
    }

    public void setCarti(Set<Carte> carti) {
        this.carti = carti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nume;
    }

    public void setName(String name) {
        this.nume = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
