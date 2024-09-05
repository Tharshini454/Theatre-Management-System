package Model;

import java.io.EOFException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFunction {

	public  static List<Employee> viewAllEmployees()
    {
        List<Employee> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                st.add(new Employee(id,email,name,age));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
	public static boolean addEmployee(String email,String name,int age)throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "INSERT INTO employee (email,name,age) VALUES (?, ?, ?)");) 
        {
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setInt(3, age);
            // Execute the SQL INSERT statement
            int rowsInserted = statement.executeUpdate();
            // Check if the insertion was successful
            if (rowsInserted > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
        
    }
}
