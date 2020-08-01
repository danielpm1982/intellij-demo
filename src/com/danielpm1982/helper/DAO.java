package com.danielpm1982.helper;
import com.danielpm1982.domain.Client;
import com.danielpm1982.domain.Order;
import com.danielpm1982.domain.OrderItem;
import com.danielpm1982.domain.Product;
import java.util.List;

class DAO {
    private static List<Client> clientList;
    private static List<Product> productList;
    private static List<Order> orderList;
    private static List<OrderItem> orderItemList;
    static{
        clientList = DB.getClientList();
        productList = DB.getProductList();
        orderList = DB.getOrderList();
        orderItemList = DB.getOrderItemList();
        if(clientList==null||productList==null||orderList==null||orderItemList==null){
            throw new RuntimeException("Error initializing DB. No DB source available ! DAO can't communicate with a DB source !");
        }
    }
    static public Object persistObject(Object o){
        if(!doesExist(o)){
            if(o instanceof Client){
                clientList.add((Client)o);
            } else if(o instanceof Product){
                productList.add((Product) o);
            } else if(o instanceof Order){
                orderList.add((Order)o);
            } else{
                orderItemList.add((OrderItem)o);
            }
            return o;
        } else {
            return retrieveObject(o);
        }
    }
    static private boolean doesExist(Object o){
        return retrieveObject(o)!=null;
    }
    static private Object retrieveObject(Object o){
        if(o instanceof Client){
            return clientList.stream().filter(x->x.getId()==((Client) o).getId()).findAny().orElse(null);
        } else if(o instanceof Product){
            return productList.stream().filter(x->x.getId()==((Product) o).getId()).findAny().orElse(null);
        } else if(o instanceof Order){
            return orderList.stream().filter(x->x.getId()==((Order) o).getId()).findAny().orElse(null);
        } else if(o instanceof OrderItem){
            return orderItemList.stream().filter((x->x.getOrderItemId()==((OrderItem) o).getOrderItemId())).findAny().orElse(null);
        }
        return null;
    }
    static public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
