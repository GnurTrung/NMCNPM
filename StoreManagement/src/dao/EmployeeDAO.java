package src.dao;

import static src.dao.JDBCConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import  src.model.Employee;
import  src.model.Admin;

public class EmployeeDAO {
    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        return instance;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> listEmployee = new ArrayList<>();
        try {

            String sql = "SELECT * FROM EMPLOYEE ";
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee Employee = new Employee();
                Employee.setID(resultSet.getString("ID"));
                Employee.setName(resultSet.getString("name"));
                Employee.setRole(resultSet.getString("Role"));
                Employee.setDoB(resultSet.getString("DOB"));
                Employee.setAddress(resultSet.getString("address"));
                Employee.setPhone(resultSet.getString("phone_number"));
                Employee.setSalary(resultSet.getInt("Salary"));
                Employee.setEmployeeName(resultSet.getString("EmployeeName"));
                Employee.setPassWord(resultSet.getString("Password"));
                listEmployee.add(Employee);

            }
            return listEmployee;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Employee> getAllEmployeeNames() {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            String sql = "SELECT EmployeeName,Password,Role FROM EMPLOYEE ";
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee Employee = new Employee();
                Employee.setEmployeeName(resultSet.getString("EmployeeName"));
                Employee.setPassWord(resultSet.getString("Password"));
                Employee.setRole(resultSet.getString("Role"));
                listEmployee.add(Employee);

            }
            return listEmployee;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void addEmployee(Employee Employee) {
        try {
            Connection connection = getConnection();

            String sql = "INSERT INTO Employeeoop (ID,"
                    + "address,phone_number,Role,Shift,Salary,EmployeeName,Password, name)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Employee.getID());
            ps.setString(2, Employee.getAddress());
            ps.setString(3, Employee.getPhone());
            ps.setString(4, Employee.getRole());
            ps.setString(6, Employee.getShift());
            ps.setLong(5, Employee.getSalary());
            ps.setString(7, Employee.getEmployeeName());
            ps.setString(8, Employee.getPassWord());
            ps.setString(9, Employee.getName());

            int rs = ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeEmployee(String ID) {
        try {
            Connection connection = getConnection();
            String sql1 = "DELETE FROM Employee WHERE ID = ? ";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, ID);
            int rs1 = ps1.executeUpdate();

            String sql = "DELETE FROM Employeeoop WHERE ID = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            int rs = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void updateEmployeeEA(Employee Employee) {
//        try {
//            Connection connection = getConnection();
//            String sql = "UPDATE Employee SET Address = ?, Phone =?, Role = ?, Shift = ?, Salary = ?, "
//                    + "EmployeeName=?,Password=? , name =? WHERE ID =?";
//
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, Employee.getID());
//            ps.setString(2, Employee.getAddress());
//            ps.setString(3, Employee.getPhone());
//            ps.setString(4, Employee.getRole());
//            ps.setString(6, Employee.getShift());
//            ps.setLong(5, Employee.getSalary());
//            ps.setString(7, Employee.getEmployeeName());
//            ps.setString(8, Employee.getPassWord());
//            ps.setString(9, Employee.getName());
//            int rs = ps.executeUpdate();
////            String sql0 = "DELETE FROM SalaryEmployee WHERE IDEmployee = ? ";
////
////            PreparedStatement ps0 = connection.prepareStatement(sql0);
////            ps0.setInt(1, Employee.getIDEmployee());
////            int rs0 = ps0.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    public void updateEmployeeAE(Employee Employee) {
//        try {
//            Connection connection = getConnection();
//            String sql = "UPDATE Employeeoop SET FullName =? ,Gender=?,Dob=?,Address=?,"
//                    + "Phone=?,EmployeeName=?,Password=? , Role =? WHERE IDEmployee =?";
//
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(9, Employee.getIDEmployee());
//            ps.setString(1, Employee.getFullName());
//            ps.setString(2, Employee.getGender());
//            ps.setString(3, Employee.getDob());
//            ps.setString(5, Employee.getPhone());
//            ps.setString(4, Employee.getAddress());
//            ps.setString(6, Employee.getEmployeeName());
//            ps.setString(7, Employee.getPassword());
//            ps.setString(8, Employee.getRole());
//            int rs = ps.executeUpdate();
//            String sql0 = "INSERT INTO SalaryEmployee (IDEmployee,Month) VALUES (?,?)";
//            for (int i = 1; i < 13; i++) {
//                PreparedStatement ps0 = connection.prepareStatement(sql0);
//                ps0.setInt(1, Employee.getIDEmployee());
//                ps0.setInt(2, i);
//                int rs0 = ps0.executeUpdate();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public void updateEmployee(Employee Employee) {
            try {
                Connection connection = getConnection();
                String sql = "UPDATE Employee SET Address = ?, phone =?, Role = ?, Shift = ?, Salary = ?, "
                        + "EmployeeName=?,Password=? , name =? WHERE ID =?";

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, Employee.getID());
                ps.setString(2, Employee.getAddress());
                ps.setString(3, Employee.getPhone());
                ps.setString(4, Employee.getRole());
                ps.setString(6, Employee.getShift());
                ps.setLong(5, Employee.getSalary());
                ps.setString(7, Employee.getEmployeeName());
                ps.setString(8, Employee.getPassWord());
                ps.setString(9, Employee.getName());
                int rs = ps.executeUpdate();
//            String sql0 = "DELETE FROM SalaryEmployee WHERE ID= ? ";
//
//            PreparedStatement ps0 = connection.prepareStatement(sql0);
//            ps0.setInt(1, Employee.getID());
//            int rs0 = ps0.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    public Employee getEmployeeByID(String ID) {

        try {

            String sql = "SELECT * FROM Employee WHERE ID =?";
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee u = new Employee();
                u.setID(resultSet.getString("ID"));
                u.setName(resultSet.getString("name"));
                u.setRole(resultSet.getString("Role"));
                u.setDoB(resultSet.getString("DOB"));
                u.setAddress(resultSet.getString("address"));
                u.setPhone(resultSet.getString("phone_number"));
                u.setSalary(resultSet.getInt("Salary"));
                u.setEmployeeName(resultSet.getString("EmployeeName"));
                u.setPassWord(resultSet.getString("Password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

//    public List<Employee> getSalaryEmployeeByID(int IDEmployee) {
//        List<Employee> listE = new ArrayList<>();
//        try {
//
//            String sql = "select Employeeoop.IDEmployee , FullName,Month,Shift, TotalShiftOnMonth,"
//                    + " MoneyShift ,Bonus from Employeeoop inner join SalaryEmployee ON Employeeoop.IDEmployee = "
//                    + "SalaryEmployee.IDEmployee where Employeeoop.Role = 'Employee' and Employeeoop.IDEmployee=? ";
//            Connection connection = getConnection();
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, IDEmployee);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Employee Employee = new Employee();
//                Employee.setIDEmployee(resultSet.getInt("IDEmployee"));
//                Employee.setFullName(resultSet.getString("FullName"));
//                Employee.setMonth(resultSet.getInt("Month"));
//                Employee.setShift(resultSet.getString("Shift"));
//                Employee.setTotalShiftOnMonth(resultSet.getInt("TotalShiftOnMonth"));
//                Employee.setMoneyShift(resultSet.getInt("MoneyShift"));
//                Employee.setBonus(resultSet.getInt("Bonus"));
//
//                listE.add(Employee);
//
//            }
//            return listE;
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }

    public List<Employee> getAllAdmins() {
        List<Employee> listE = new ArrayList<>();
        try {

            String sql = "select ID , name, Gender,DOB,address,"
                    + " phone_number from EMPLOYEE where Role like 'Admin'";

            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Admin ad = new Admin();
                ad.setID(resultSet.getString("ID"));
                ad.setName(resultSet.getString("name"));
                ad.setRole(resultSet.getString("Role"));
                ad.setDoB(resultSet.getString("DOB"));
                ad.setAddress(resultSet.getString("address"));
                ad.setPhone(resultSet.getString("phone_number"));
                ad.setSalary(resultSet.getInt("Salary"));
                ad.setEmployeeName(resultSet.getString("EmployeeName"));
                ad.setPassWord(resultSet.getString("Password"));
                listE.add(ad);

            }
            return listE;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateEmployeePassword(Employee Employee, String newPass) {
        try {
            Connection connection = getConnection();
            String sql = "UPDATE EMPLOYEE SET Password=? WHERE ID =?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(2, Employee.getID());
            ps.setString(1, newPass);

            int rs = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
