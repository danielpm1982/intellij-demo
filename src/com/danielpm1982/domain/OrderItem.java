package com.danielpm1982.domain;
import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {
    private long orderItemId;
    private Order order;
    private int quantity;
    private BigDecimal discount;
    private BigDecimal price;
    private String info;
    private Product product;
    public OrderItem() {
    }
    public OrderItem(long orderItemId, Order order, int quantity, BigDecimal discount, BigDecimal price, String info, Product product) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
        this.info = info;
        this.product = product;
    }
    public long getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", order=" + order +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", product=" + product +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId &&
                quantity == orderItem.quantity &&
                order.equals(orderItem.order) &&
                discount.equals(orderItem.discount) &&
                price.equals(orderItem.price) &&
                Objects.equals(info, orderItem.info) &&
                product.equals(orderItem.product);
    }
    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, order, quantity, discount, price, info, product);
    }
}
