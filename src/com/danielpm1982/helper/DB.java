package com.danielpm1982.helper;
import com.danielpm1982.domain.Client;
import com.danielpm1982.domain.Order;
import com.danielpm1982.domain.OrderItem;
import com.danielpm1982.domain.Product;
import java.util.ArrayList;
import java.util.List;

class DB {
    private static List<Client> clientList;
    private static List<Product> productList;
    private static List<Order> orderList;
    private static List<OrderItem> orderItemList;
    static{
        clientList = new ArrayList<>();
        productList = new ArrayList<>();
        orderList = new ArrayList<>();
        orderItemList = new ArrayList<>();
    }
    static List<Client> getClientList() {
        return clientList;
    }
    static List<Order> getOrderList() {
        return orderList;
    }
    static List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    static List<Product> getProductList() {
        return productList;
    }
}
