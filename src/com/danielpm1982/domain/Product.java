package com.danielpm1982.domain;
import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private String description;
    private String info;
    public Product() {
    }
    public Product(long id, String name, String description, String info) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                Objects.equals(info, product.info);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, info);
    }
}
