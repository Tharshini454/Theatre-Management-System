package Controller;

import java.util.List;


import Model.EmployeeFunction;

import Model.ShowFunction;
import Model.Snack;
import Model.UserFunction;

public class EmployeeController {
	public static boolean addEmployee(String email,String name,int age) throws Exception
    {
        boolean b=EmployeeFunction.addEmployee(email,name,age);
        return b;
    }
	public static boolean removeEmployee(int id) throws Exception
    {
        boolean b=UserFunction.removeEmployee(id);
        return b;
    } 
//	public static List<Show> viewAllShows()
//    {
//        List<Show> st =ShowFunction.viewAllShows();
//        return st;
//    }
	public static List<Snack> viewAllSnacks()
    {
        List<Snack> st =ShowFunction.viewAllSnacks();
        return st;
    }
	
}
