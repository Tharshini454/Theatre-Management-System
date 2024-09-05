package Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import Model.C_Bill;
import Model.Show;
import Model.ShowFunction;
import Model.SnackFunction;

public class ShowController {
	public static Show searchShow(String movie) throws Exception
    {
        try
        {
            Show sh=ShowFunction.searchShow(movie);
            return sh;
        }
        catch(Exception e)
        {
            throw new Exception("Error during searching");
        }
    } 
	public static boolean updateAvailableSeats(int n,String movie_name) throws Exception
    {
        try{
            if(ShowFunction.updateAvailableSeats(n,movie_name)) 
            	return true;
            else    
            	return false;
            }
            catch(Exception e)
            {
                throw new Exception("Error During Booking");
            }
    } 
	public static int addScreen(String movie_name) throws Exception
    {
    	try
    	{
    		int screen=ShowFunction.addScreen(movie_name);
    		return screen;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The screen is not available");
    	}
    }
	public static int addSeats(String movie_name) throws Exception
    {
    	try
    	{
    		int seats=ShowFunction.addSeats(movie_name);
    		return seats;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The seat is not available");
    	}
    }
	public static String addTime(String movie_name) throws Exception
    {
    	try
    	{
    		String time=ShowFunction.addTime(movie_name);
    		return time;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The screen is not available");
    	}
    }
	public static Date addDate(String movie_name) throws Exception
    {
    	try
    	{
    		Date m_date=ShowFunction.addDate(movie_name);
    		return m_date;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The screen is not available");
    	}
    }
	public static int addPrice(String movie_name) throws Exception
    {
    	try
    	{
    		int price=ShowFunction.addPrice(movie_name);
    		return price;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The screen is not available");
    	}
    }
	public static boolean addSnack(int s_id,String name,int quantity,int price) throws Exception
    {
        boolean b=SnackFunction.addSnack(s_id,name,quantity,price);
        return b;
    }
	public static int addsnackPrice(String name) throws Exception
	{
		try
		{
			int price=ShowFunction.addsnackPrice(name);
			return price;
		}
		catch(Exception e)
		{
			throw new Exception("The screen is not available");
		}
	}
	public static boolean addToBill(String email ,String movie_name,Date m_date,String time,int screen,LocalDate b_date,int price) throws Exception
    {
        try
        {
            boolean b=ShowFunction.addToBill(email,movie_name,m_date,time,screen,b_date,price);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
	public static boolean addTocBill(String email ,String movie_name,Date m_date,String time,int screen,int price) throws Exception
    {
        try
        {
            boolean b=ShowFunction.addTocBill(email,movie_name,m_date,time,screen,price);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
	public static List<C_Bill> viewcBills()
    {
        List<C_Bill> st =ShowFunction.viewcBills();
        return st;
    }
	public static boolean deleteTable() throws Exception
    {
    	boolean b=ShowFunction.deleteTable();
    	return b;
    }
}
