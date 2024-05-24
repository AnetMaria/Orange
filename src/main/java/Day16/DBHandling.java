package Day16;

import java.sql.*;

public class DBHandling {
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
        ResultSet result = stmt.executeQuery("select * from Employee.EmployeeDetails");
        //To print out the ResultSet

        ResultSetMetaData metaD = result.getMetaData();
        int columnCount = metaD.getColumnCount();
        System.out.println(columnCount);
        while(result.next()){//this loop is for going through rows

            for(int iCol=1;iCol<=columnCount;iCol++){//this is for columns
                String columnName = metaD.getColumnName(iCol);
                String rowValue = result.getString(iCol);//RowValue is in the ResultSet
                System.out.println(columnName+"======"+rowValue);
            }

            //hardcoded value printing
//            System.out.println(result.getString("Emp_id"));
//            System.out.println(result.getString("Emp_Name"));
        }
        con.close();
    }
}
