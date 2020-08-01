package com.danielpm1982.domain;
import java.time.LocalDate;
import java.util.Objects;

public class Client{
    private long id;
    private String name;
    private String email;
    private String street;
    private int streetNumber;
    private String city;
    private String country;
    private LocalDate birthDate;
    private String info;
    public Client() {
    }
    public Client(long id, String name, String email, String street, int streetNumber, String city, String country, LocalDate birthDate, String info) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
        this.info = info;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                ", info='" + info + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                streetNumber == client.streetNumber &&
                name.equals(client.name) &&
                email.equals(client.email) &&
                street.equals(client.street) &&
                city.equals(client.city) &&
                country.equals(client.country) &&
                birthDate.equals(client.birthDate) &&
                Objects.equals(info, client.info);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, street, streetNumber, city, country, birthDate, info);
    }
}
