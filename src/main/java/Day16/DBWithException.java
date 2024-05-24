package Day16;

import java.sql.*;
//customized exception
public class DBWithException {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, myProjectExceptions {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        try {
            con = DriverManager.getConnection("jdbc:mysql1://localhost:3306/Employee", "root", "AnetMaria20##");
        }catch(Exception e){
            System.out.println(e.toString());
        }
            if (con != null) {
                System.out.println("Connection is established");
            } else {
                throw new myProjectExceptions("Try Again");
            }


            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("select * from Employee.EmployeeDetails");
            //To print out the ResultSet

            ResultSetMetaData metaD = result.getMetaData();
            int columnCount = metaD.getColumnCount();
            System.out.println(columnCount);
            while (result.next()) {//this loop is for going through rows

                for (int iCol = 1; iCol <= columnCount; iCol++) {//this is for columns
                    String columnName = metaD.getColumnName(iCol);
                    String rowValue = result.getString(iCol);//RowValue is in the ResultSet
                    System.out.println(columnName + "======" + rowValue);
                }
        }
            con.close();
    }
}
