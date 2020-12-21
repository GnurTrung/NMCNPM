package src.service;

import src.dao.EmployeeDAO;
import java.util.List;
import src.model.Employee;
import src.model.Admin;
public class EmployeeService {
    private EmployeeDAO EmployeeDAO;


    public EmployeeService() {
        EmployeeDAO = new EmployeeDAO();

    }

    public List<Employee> getAllEmployee() {
        return EmployeeDAO.getAllEmployees();
    }

    public void addEmployee(Employee Employee) {
        EmployeeDAO.addEmployee(Employee);
    }

    public void updateEmployee(Employee u) {
        EmployeeDAO.updateEmployee(u);
    }

    public void removeEmployee(String IDEmployee) {
        EmployeeDAO.removeEmployee(IDEmployee);
    }

    public List<Employee> getAllEmployeeNames() {
        return EmployeeDAO.getAllEmployeeNames();
    }

    public List<Employee> getAllEmployees() {
        return EmployeeDAO.getAllEmployees();
    }

    public Employee getEmployeeByID(String IDEmployee) {

        return EmployeeDAO.getEmployeeByID(IDEmployee);
    }


    public  void changPassEmployee(Employee Employee, String newPass){
        EmployeeDAO.updateEmployeePassword(Employee, newPass);
    }
}
