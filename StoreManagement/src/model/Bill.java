package src.model;
import java.util.ArrayList;

public class Bill {
    private int IDOrder, total;

    private String date;

    private Customer customer;

    ArrayList<Product> listOrderProduct;

    public Bill(){

    }

    public Bill(int IDOrder, int total, String date, ArrayList<Product> listOrderProduct, Customer customer){
        this.IDOrder = IDOrder;
        this.total = total;
        this.date = date;
        this.listOrderProduct = listOrderProduct;
        this.customer = customer;
    }

    public int getIDOrder() {
        return IDOrder;
    }

    public int getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }

    public void setIDOrder(int IDOrder) {
        this.IDOrder = IDOrder;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Product> getListOrderProduct() {
        return listOrderProduct;
    }

    public void setListOrderProduct(ArrayList<Product> listOrderProduct) {
        this.listOrderProduct = listOrderProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

