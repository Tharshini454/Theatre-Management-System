package View;
import java.util.*;


import Controller.AdminController;
import Controller.EmployeeController;
import Controller.UserController;
import Model.Bill;
import Model.Show;
import Model.User;
public class AdminView 
{
    //private static final String AdminFunction = null;
	static Scanner sc=new Scanner(System.in);
    public static void menu()
    {
        boolean b=true;
        do
        {
            System.out.println();
            System.out.println(" 1.View Customer bills \n 2.View users \n 3.View all shows \n 4.Add Employee \n "
            		+ "5.Remove Employee \n 6.Add show \n 7.Remove show  \n 8.Exit");
            System.out.println();
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            switch(a)
            {
                case 1:
                	List<Bill> billsList = AdminController.viewAllBills();;
                    if (!billsList.isEmpty()) 
                    {
                        System.out.println("--List of Bills--");
                        for (Bill ve : billsList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Bills found.");
                    break;
                case 3:
                	List<Show> showsList = AdminController.viewAllShows();;
                    if (!showsList.isEmpty()) 
                    {
                        System.out.println("--List of Shows--");
                        for (Show ve : showsList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Shows found.");
                    break;
                case 2:
                    List<User> List = UserController.viewAllUsers();;
                    if (!List.isEmpty()) 
                    {
                        System.out.println("--List of Users--");
                        for (User ve : List)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Users found.");
                    break;
                case 4:
                	System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    // String designation = "manager";
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    try
                    {
                        // boolean ad=AdminFunction.addManager(email,password,name,designation);
                        boolean uc=UserController.addUser(email, password,"employee");
                        boolean bt=EmployeeController.addEmployee(email,name,age);
                        if(uc&&bt)  System.out.println("A new employee has been inserted into the database.");
                        else    
                        System.out.println("Failed to insert employee into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert employee into the database.");
                    }
                    break;
                case 5:
                	System.out.print("Enter the employee id to delete: ");
                    int idToDelete = sc.nextInt();
                    try
                    {
                        boolean ad=UserController.removeEmployee(idToDelete);
                        if(ad)  System.out.println("Employee has been removed from the database.");
                        else    
                        System.out.println("Failed to remove employee from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove employee from the database.");
                    }
                    break;
                case 6:
                	System.out.print("Enter movie name: ");
                    String movie_name = sc.nextLine();
                    System.out.print("Enter date: ");
                    String date = sc.next();
                    sc.nextLine();
                    System.out.print("Enter time: ");
                    String time = sc.nextLine();
                    // String designation = "manager";
                    System.out.print("Enter screen : ");
                    int screen = sc.nextInt();
                    System.out.print("Enter seat: ");
                    int seats=sc.nextInt();
                    System.out.print("Enter price : ");
                    int price=sc.nextInt();
                    try
                    {
                        boolean uc=UserController.addShow(movie_name,date,time,screen,seats,price);
                        if(uc)  System.out.println("A new show has been inserted into the database.");
                        else    
                        System.out.println("Failed to insert show into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert show into the database.");
                    }
                    break;
                case 7:
                   	System.out.print("Enter the movie name to delete: ");
                    String movienameToDelete = sc.nextLine();
                    try
                    {
                        boolean ad=UserController.removeShow(movienameToDelete);
                        if(ad)  System.out.println("Show has been removed from the database.");
                        else    
                        System.out.println("Failed to remove show from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove show from the database.");
                    }
                    break;  
                    
                case 8:
                    System.out.println("--Nandrii--");
                    b=false;
                    break;
            }
        }
        while(b);
    } 
}

