package Controller;
import java.util.List;

import Model.*;
import View.*;

public class UserController
{
    public  boolean validateUser(String email,String pass) throws Exception
    {
        try
        {
            String dbpass=UserFunction.getPassword(email);
            if(dbpass.equals(pass))
                return true;
            else 
                return false;
        }
        catch(Exception e)
        {
            throw new Exception("--- Enter valid Details ---");
        }
    }
    public void chooseMenu(String email)throws Exception
    {
        try
        {
            String role=UserFunction.getRoleByEmail(email);
            if(role.equals("admin"))
                AdminView.menu();
            else if(role.equals("employee"))
            {
                    EmployeeView.menu();
            }
            else 
                CustomerView.menu();
        }
        catch(Exception e)
        {
            throw new Exception("--- Error During choosing role ---");
        }
    }
    public static boolean addUser(String email,String pass,String role) throws Exception
    {
        try
        {
            boolean b=UserFunction.addUser(email,pass,role);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion doesn't performed");
        }
    }
    public static boolean removeEmployee(int id) throws Exception
    {
        boolean b=UserFunction.removeEmployee(id);
        return b;
    } 
    public static List<User> viewAllUsers()
    {
        List<User> st =UserFunction.viewAllUsers();
        return st;
    }
    public static boolean addShow(String movie_name,String date,String time,int screen,int seats,int price) throws Exception
    {
        try
        {
            boolean b=UserFunction.addShow(movie_name,date,time,screen,seats,price);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion doesn't performed");
        }
    }
    public static boolean removeShow(String movie_name) throws Exception
    {
        boolean b=UserFunction.removeShow(movie_name);
        return b;
    }
}