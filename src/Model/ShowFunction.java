package Model;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowFunction {
	public  static List<Show> viewAllShows()
    {
        List<Show> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM movies");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                String movie_name = resultSet.getString("movie_name");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                int screen = resultSet.getInt("screen");
                int seats=resultSet.getInt("seats");
                int price=resultSet.getInt("price");
                st.add(new Show(movie_name,date,time,screen,seats,price));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
	public static Show searchShow(String movie) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM movies WHERE movie_name = ? ");) 
        {
            statement.setString(1, movie);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                if (resultSet.next()) 
                {
                String movie_name = resultSet.getString("movie_name");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                int screen = resultSet.getInt("screen");
                int seats = resultSet.getInt("seats");
                int price = resultSet.getInt("price");
                return new Show(movie_name,date,time,screen,seats,price);
                    // System.out.println(" ID: " + id +" || Name: "+name +" || Email: " + email + " || Designation: " + designation);
                } 
                else 
                {
                    throw new Exception("Data not found");
                }
            }
        }
    }
	 public static boolean updateAvailableSeats(int seats, String movie_name) throws Exception 
	    {
	        String sqlSelect = "SELECT seats FROM movies WHERE movie_name = ?";
	        String sqlUpdate = "UPDATE movies SET seats = seats - ? WHERE movie_name = ?";
	        
	        int availableSeats;
	        try (
	             PreparedStatement selectStatement = DBconnectivity.getConnection().prepareStatement(sqlSelect);
	             PreparedStatement updateStatement = DBconnectivity.getConnection().prepareStatement(sqlUpdate)) {
				selectStatement.setString(1, movie_name);
	            try (ResultSet resultSet = selectStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    availableSeats = resultSet.getInt("seats");
	                    
	                } else {
	                    throw new SQLException("Show with name " + movie_name + " not found.");
	                }
	            }
	            if (availableSeats < seats) {
	                throw new Exception("there is no available tickets for your availability " + movie_name);
	            }
	            
	            else if(availableSeats==0)
	            throw new Exception("House is full for show  " + movie_name);
	            
	            // Update the available seats count
	            updateStatement.setInt(1, seats);
	            updateStatement.setString(2, movie_name);
	            int rowsAffected = updateStatement.executeUpdate();
	            return rowsAffected>0;
	        }
	    }
	 public static int addScreen(String movie_name) throws Exception
	    {
	    	int screen =0;
			try (
	                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
	                        "SELECT screen FROM movies WHERE movie_name = ?")) 
	           {
				   statement.setString(1, movie_name);
	               ResultSet resultSet = statement.executeQuery();
	               if (resultSet.next()) {
	                   screen = resultSet.getInt("screen");
	               } 
	               resultSet.close();
	               statement.close();
	           } 
	    	catch (SQLException e) {
	               e.printStackTrace();
	               throw new Exception("DB ERROR");
	           }
	    	return screen;
	    }
	 public static int addSeats(String movie_name) throws Exception
	    {
	    	int seats =0;
			try (
	                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
	                        "SELECT seats FROM movies WHERE movie_name = ?")) 
	           {
				   statement.setString(1, movie_name);
	               ResultSet resultSet = statement.executeQuery();
	               if (resultSet.next()) {
	                   seats = resultSet.getInt("seats");
	               } 
	               resultSet.close();
	               statement.close();
	           } 
	    	catch (SQLException e) {
	               e.printStackTrace();
	               throw new Exception("DB ERROR");
	           }
	    	return seats;
	    }
	 public static String addTime(String movie_name) throws Exception
	    {
	    	String time =null;
			try (
	                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
	                        "SELECT time FROM movies WHERE movie_name = ?")) 
	           {
				   statement.setString(1, movie_name);
	               ResultSet resultSet = statement.executeQuery();
	               if (resultSet.next()) {
	                   time = resultSet.getString("time");
	               } 
	               resultSet.close();
	               statement.close();
	           } 
	    	catch (SQLException e) {
	               e.printStackTrace();
	               throw new Exception("DB ERROR");
	           }
	    	return time;
	    }
	 public static Date addDate(String movie_name) throws Exception
	    {
	    	Date m_date = null;
			try (
	                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
	                        "SELECT date FROM movies WHERE movie_name = ?")) 
	           {
				   statement.setString(1, movie_name);
	               ResultSet resultSet = statement.executeQuery();
	               if (resultSet.next()) {
	                   m_date = resultSet.getDate("date");
	               } 
	               resultSet.close();
	               statement.close();
	           } 
	    	catch (SQLException e) {
	               e.printStackTrace();
	               throw new Exception("DB ERROR");
	           }
	    	return m_date;
	    }
	    public static boolean addToBill(String email,String movie_name,Date m_date,String time,int screen,LocalDate b_date,int price) throws SQLException {
	        String sql = "INSERT INTO bill (email,movie_name,m_date,time,screen,b_date,price) VALUES (?, ?,?,?,?, ?,?)";
	        try (
	             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
	  
	            statement.setString(1,email);
	            statement.setString(2, movie_name);
	            statement.setDate(3,m_date);
	            statement.setString(4, time);
	            statement.setInt(5, screen);
	            Date sqldate=Date.valueOf(b_date);
	            statement.setDate(6,sqldate);
	            statement.setInt(7, price);
	    
	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0; // Return true if a row was inserted
	        } catch (SQLException e) {
	            e.printStackTrace(); // Print the stack trace for debugging
	            throw e; // Re-throw the exception to propagate it to the caller
	        }
	    }
	    public static boolean addTocBill(String email,String movie_name,Date m_date,String time,int screen,int price) throws SQLException {
	        String sql = "INSERT INTO c_bill (email,movie_name,m_date,time,screen,price) VALUES (?, ?,?,?,?, ?)";
	        try (
	             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
	  
	            statement.setString(1,email);
	            statement.setString(2, movie_name);
	            statement.setDate(3,m_date);
	            statement.setString(4, time);
	            statement.setInt(5, screen);
	            statement.setInt(6, price);
	          
	    
	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0; // Return true if a row was inserted
	        } catch (SQLException e) {
	            e.printStackTrace(); // Print the stack trace for debugging
	            throw e; // Re-throw the exception to propagate it to the caller
	        }
	    }
	    public  static List<C_Bill> viewcBills()
	    {
	        List<C_Bill> st = new ArrayList<>();
	        try (
	        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM C_bill");
	        ResultSet resultSet = statement.executeQuery()) 
	        {
	            while (resultSet.next()) 
	            {
	                String email = resultSet.getString("email");
	                String movie_name = resultSet.getString("movie_name");
	                Date m_date=resultSet.getDate("m_date");
	                String time = resultSet.getString("time");
	                int screen = resultSet.getInt("screen");
	                int price = resultSet.getInt("price");
	               
	                st.add(new C_Bill(email,movie_name,m_date,time,screen,price));
	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return st;
	    }
		public  static List<Snack> viewAllSnacks()
	    {
	        List<Snack> st = new ArrayList<>();
	        try (
	        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM snack");
	        ResultSet resultSet = statement.executeQuery()) 
	        {
	            while (resultSet.next()) 
	            {
	                int s_id = resultSet.getInt("s_id");
	                String name = resultSet.getString("name");
	                int quantity = resultSet.getInt("quantity");
	                int price = resultSet.getInt("price");
	                st.add(new Snack(s_id,name,quantity,price));
	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return st;
	    }
		 public static int addPrice(String movie_name) throws Exception
		    {
		    	int price =0;
				try (
		                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
		                        "SELECT price FROM movies WHERE movie_name = ?")) 
		           {
					   statement.setString(1, movie_name);
		               ResultSet resultSet = statement.executeQuery();
		               if (resultSet.next()) {
		                   price = resultSet.getInt("price");
		               } 
		               resultSet.close();
		               statement.close();
		           } 
		    	catch (SQLException e) {
		               e.printStackTrace();
		               throw new Exception("DB ERROR");
		           }
		    	return price;
		    }
		 public static boolean deleteTable() throws Exception
		    {
		        try (
		             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
		                     "DELETE FROM c_bill")) 
		        {
		            // Execute the delete query
		            int rowsDeleted = statement.executeUpdate();
		            // Check if any rows were deleted
		            if (rowsDeleted > 0) {
		                return true;
		            } else {
		                return false;
		            }
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		            throw new Exception("DB ERROR");
		        }
		    }
		 public static int addsnackPrice(String name) throws Exception
		    {
		    	int price =0;
				try (
		                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
		                        "SELECT price FROM snack WHERE name = ?")) 
		           {
					   statement.setString(1, name);
		               ResultSet resultSet = statement.executeQuery();
		               if (resultSet.next()) {
		                   price = resultSet.getInt("price");
		               } 
		               resultSet.close();
		               statement.close();
		           } 
		    	catch (SQLException e) {
		               e.printStackTrace();
		               throw new Exception("DB ERROR");
		           }
		    	return price;
		    }
}



