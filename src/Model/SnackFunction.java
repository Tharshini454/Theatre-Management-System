package Model;

import java.io.EOFException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SnackFunction {
	
	public static boolean updateSnack(int new_quantity,String snack_name) throws Exception
    {
        try (
        		PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                    "UPDATE snack SET quantity=?  where  name=?")) 
       {
           statement.setInt(1, new_quantity);
            statement.setString(2,snack_name);
           // Execute the delete query
           int rowsUpdated = statement.executeUpdate();
           // Check if any rows were deleted
           if (rowsUpdated > 0) {
               return true;
           } else {
               return false;
           }
           
       } catch (SQLException e) {
           e.printStackTrace();
           throw new Exception("DB ERROR");
       }
    }
	public static boolean addSnack(int s_id,String name,int quantity,int price)throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "INSERT INTO snack (s_id,name,quantity,price) VALUES (?, ?, ?, ?)");) 
        {
            statement.setInt(1, s_id);
            statement.setString(2, name);
            statement.setInt(3, quantity);
            statement.setInt(4, price);

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
