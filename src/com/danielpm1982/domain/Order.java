package com.danielpm1982.domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Order {
    private long id;
    private LocalTime time;
    private LocalDate date;
    private String info;
    private Client client;
    public Order() {
    }
    public Order(long id, LocalTime time, LocalDate date, String info, Client client) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.info = info;
        this.client = client;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time=" + time +
                ", date=" + date +
                ", info='" + info + '\'' +
                ", client=" + client +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                time.equals(order.time) &&
                date.equals(order.date) &&
                Objects.equals(info, order.info) &&
                client.equals(order.client);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, time, date, info, client);
    }
}
