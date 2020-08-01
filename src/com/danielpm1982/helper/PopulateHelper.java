package com.danielpm1982.helper;
import com.danielpm1982.domain.Client;
import com.danielpm1982.domain.Order;
import com.danielpm1982.domain.OrderItem;
import com.danielpm1982.domain.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class PopulateHelper {
    public static List<OrderItem> populateSampleData(){
        Client c1 = createAndAddClient(1, "client1", "client1@client.com", "street1", 100, "cityA", "countryA", LocalDate.of(1980, 5, 1), null);
        Client c2 = createAndAddClient(2, "client2", "client2@client.com", "street2", 100, "cityB", "countryA", LocalDate.of(1990, 1, 10), "testing the info field");
        Client c3 = createAndAddClient(3, "client3", "client3@client.com", "street3", 100, "cityC", "countryB", LocalDate.of(2000, 2, 20), "only some additional info");
        Client c4 = createAndAddClient(4, "client4", "client4@client.com", "street4", 100, "cityD", "countryB", LocalDate.of(1982, 8, 2), null);
        Product p1 = createAndAddProduct(1, "p1", "description1", null);
        Product p2 = createAndAddProduct(2, "p2", "description2", "this product is really awesome !");
        Product p3 = createAndAddProduct(3, "p3", "description3", "this is a promotional product !");
        Order orderClient1 = createAndAddOrder(1, LocalTime.now(), LocalDate.now(), "client1 made this order", c1);
        Order orderClient2 = createAndAddOrder(2, LocalTime.now(), LocalDate.now(), "client2 made this order", c2);
        Order orderClient3 = createAndAddOrder(3, LocalTime.now(), LocalDate.now(), "client3 made this order", c3);
        Order orderClient4 = createAndAddOrder(4, LocalTime.now(), LocalDate.now(), "client4 made this order", c4);
        OrderItem orderItemOrderClient1Product1 = createAndAddOrderItem(1, orderClient1, 5, BigDecimal.valueOf(50.00), BigDecimal.valueOf(150.00), null, p1);
        OrderItem orderItemOrderClient1Product2 = createAndAddOrderItem(2, orderClient1, 5, BigDecimal.valueOf(10.00), BigDecimal.valueOf(210.00), null, p2);
        OrderItem orderItemOrderClient1Product3 = createAndAddOrderItem(3, orderClient1, 5, BigDecimal.valueOf(20.00), BigDecimal.valueOf(350.00), null, p3);
        OrderItem orderItemOrderClient2Product2 = createAndAddOrderItem(4, orderClient2, 20, BigDecimal.valueOf(0.00), BigDecimal.valueOf(210.00), null, p2);
        OrderItem orderItemOrderClient2Product1 = createAndAddOrderItem(5, orderClient2, 10, BigDecimal.valueOf(0.00), BigDecimal.valueOf(150.00), null, p1);
        OrderItem orderItemOrderClient3Product3 = createAndAddOrderItem(6, orderClient3, 10, BigDecimal.valueOf(0.00), BigDecimal.valueOf(350.00), null, p3);
        OrderItem orderItemOrderClient4Product1 = createAndAddOrderItem(7, orderClient4, 10, BigDecimal.valueOf(0.00), BigDecimal.valueOf(150.00), null, p1);
        return Arrays.asList(orderItemOrderClient1Product1, orderItemOrderClient1Product2, orderItemOrderClient1Product3, orderItemOrderClient2Product2, orderItemOrderClient2Product1, orderItemOrderClient3Product3, orderItemOrderClient4Product1);
        //returns to the calling method the just added sample data through an OrderItem list. DOES NOT return the static OrderItem list from the DB (getOrderItemList() does that). So that, at the Main testing class, over an iteration that tries multiple calls to this method, you can check if the DB list is really ignoring already existent same-PK instances or storing them in multiplicity (breaking key integrity constrain rule). If the DB tables were storing multiple same-PK data, when this method was called more than once, the DB static OrderItem list would end up with much more instances than the returning list from this method, this one with only the data generated at the current call and NOT from other previous ones.
    }
    private static Client createAndAddClient(long id, String name, String email, String street, int streetNumber, String city, String country, LocalDate birthDate, String info){
        Client temp = new Client(id, name, email, street, streetNumber, city, country, birthDate, info);
        Object persistedObject = DAO.persistObject(temp);
        if(persistedObject instanceof Client){
            return (Client)persistedObject;
        } else{
            return null;
        }
    }
    private static Product createAndAddProduct(long id, String name, String description, String info){
        Product temp = new Product(id, name, description, info);
        Object persistedObject = DAO.persistObject(temp);
        if(persistedObject instanceof Product){
            return (Product) persistedObject;
        } else{
            return null;
        }
    }
    private static Order createAndAddOrder(long id, LocalTime time, LocalDate date, String info, Client client){
        Order temp = new Order(id, time, date, info, client);
        Object persistedObject = DAO.persistObject(temp);
        if(persistedObject instanceof Order){
            return (Order) persistedObject;
        } else{
            return null;
        }
    }
    private static OrderItem createAndAddOrderItem(long orderItemId, Order order, int quantity, BigDecimal discount, BigDecimal price, String info, Product product){
        OrderItem temp = new OrderItem(orderItemId, order, quantity, discount, price, info, product);
        Object persistedObject = DAO.persistObject(temp);
        if(persistedObject instanceof OrderItem){
            return (OrderItem) persistedObject;
        } else{
            return null;
        }
    }
    public static List<OrderItem> getOrderItemList(){
        return DAO.getOrderItemList();
    }
}
