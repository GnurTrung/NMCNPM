package src.service;

import src.dao.CustomerDAO;
import java.util.List;
import src.model.Customer;

public class CustomerService {
    private CustomerDAO CustomerDAO;

    public CustomerService() {
        CustomerDAO = new CustomerDAO();
    }
    public List<Customer> getAllCustomers() {
        return CustomerDAO.getAllCustomers();
    }

    public List<Customer> getCustomersByName(String name){
        return CustomerDAO.getCustomersByName(name);
    }
    public  void removeCustomer(String IDCustomer){
        CustomerDAO.removeCustomer(IDCustomer);
    }
    public void updateGoods(Customer g) {
        CustomerDAO.updateCustomer(g);
    }
    public Customer getCustomersByID(int ID){
        return CustomerDAO.getCustomersByID(ID);
    }
    public Customer getCustomersByPhone(String phone){
        return CustomerDAO.getCustomersByPhone(phone);
    }
    public  void addCustomer(Customer g){
        CustomerDAO.addCustomer(g);
    }
}
