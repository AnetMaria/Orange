package Day16;

import java.sql.*;

public class DBHandling_DML {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","AnetMaria20##");
        if(con!=null){
            System.out.println("Connection is established");
        }else{
            System.out.println("Connection attempt failed");
        }

        Statement stmt = con.createStatement();
        stmt.executeUpdate("update Employee.EmployeeDetails set Emp_Name='Aniket' where Emp_ID=104");
        //stmt.executeUpdate("insert into employee.employeedetails value(105,'Praveen')");
        con.close();
    }
}
