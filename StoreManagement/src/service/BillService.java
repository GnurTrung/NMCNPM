package src.service;

import src.dao.BillDAO;
import src.model.Bill;

import java.util.List;
public class BillService {
    private static BillService instance;

    public static BillService getInstance(){
        if (instance == null){
            instance = new BillService();
        }
        return instance;
    }
//    private BillDAO billDAO = new BillDAO();
    public  List<Bill> getAllBills(){
        return BillDAO.getInstance().getAllBills();
    }
    public Bill getBillByID(int IDOrder){
        return  BillDAO.getInstance().getBillByID(IDOrder);
    }
    public void addBill(Bill b){
        BillDAO.getInstance().addBill(b);
    }
    public void removeBill(int IDOrder){
        BillDAO.getInstance().removeBill(IDOrder);
    }
    public void removeAllBills(){
        BillDAO.getInstance().removeAllBills();
    }
    public List<Bill> getBillByDate(String date){
        return BillDAO.getInstance().getBillByDate(date);
    }
}
