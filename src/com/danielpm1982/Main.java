package com.danielpm1982;
import com.danielpm1982.domain.OrderItem;
import com.danielpm1982.helper.PopulateHelper;
import java.util.List;

public class Main {
    private static final String HELLO = "Hello World !";
    public static List<OrderItem> orderItemList;
    public static void main(String[] args) {
        System.out.println(HELLO);
        System.out.println("\nPopulate data at the DB:");
        populateSampleData();
        System.out.println(orderItemList.size()+" OrderItem instances added with respective Order, Client and Product data !\nPopulated Successfully !");
        System.out.println("\nPrint data for all clients with orders:");
        printData();
        System.out.println("\nPrint data per client with orders:");
        printDataPerClient();
    }
    public static void populateSampleData() {
        orderItemList = PopulateHelper.populateSampleData();
    }
    private static void printData() {
        orderItemList.stream().forEach(System.out::println);
    }
    private static void printDataPerClient(){
        long numberOfClientsWithOrders = orderItemList.stream().map(x->x.getOrder().getClient()).distinct().count(); //gets, from the OrderItem list, the number of distinct Client instances with at least one Order referring to it. Clients with no Order won't be reachable from the OrderItem instances list.
        for(long i=0; i<numberOfClientsWithOrders; i++){
            final long tempId = i+1;
            System.out.println("Print data for client id = "+tempId);
            orderItemList.stream().filter(x->x.getOrder().getClient().getId()==tempId).forEach(System.out::println);
        }
        System.out.println("\nTotal clients with orders at the DB: "+numberOfClientsWithOrders+" clients.");
    }
}
