package src.service;

import src.dao.BillDAO;
import src.model.Bill;

import java.util.List;
public class BillService {
    private BillDAO billDAO = new BillDAO();
    public  List<Bill> getAllBills(){
        return billDAO.getAllBills();
    }
    public Bill getBillByID(int IDOrder){
        return  billDAO.getBillByID(IDOrder);
    }
    public void addBill(Bill b){
        billDAO.addBill(b);
    }
    public void removeBill(int IDOrder){
        billDAO.removeBill(IDOrder);
    }
    public void removeAllBills(){
        billDAO.removeAllBills();
    }
    public List<Bill> getBillByDate(String date){
        return billDAO.getBillByDate(date);
    }
}
