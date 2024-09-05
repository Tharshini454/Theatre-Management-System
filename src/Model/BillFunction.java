package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillFunction {

	public  static List<Bill> viewAllBills()
    {
        List<Bill> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM bill");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                String email = resultSet.getString("email");
                String movie_name = resultSet.getString("movie_name");
                Date m_date=resultSet.getDate("m_date");
                String time = resultSet.getString("time");
                int screen = resultSet.getInt("screen");
                Date b_date=resultSet.getDate("b_date");
                int price = resultSet.getInt("price");
                st.add(new Bill(email,movie_name,m_date,time,screen,b_date,price));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
}
