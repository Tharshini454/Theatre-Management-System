package View;
import java.time.LocalDate;

import java.sql.Date;
import java.util.*;

import Controller.CustomerController;
import Controller.EmployeeController;
import Controller.ShowController;
import Model.C_Bill;
import Model.Show;
import Model.Snack;

public class CustomerView 
{
    static Scanner sc=new Scanner(System.in);
    public static void menu() throws Exception
    {
        boolean b=true;
        do
        {
            System.out.println();
            System.out.println(" 1.View movie details \n 2.Book ticket  \n 3.Buy Snack \n 4.Exit");
            System.out.println();
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            switch(a)
            {
                case 1:
                	List<Show> showsList = CustomerController.viewAllShows();;
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
                    System.out.print("Enter movie_name: ");
                    String movie_name=sc.nextLine();
                    System.out.print("Enter how many tickets do you need: ");
                    int n=sc.nextInt();
                    sc.nextLine();
                    try
                    {
                        if(ShowController.updateAvailableSeats(n,movie_name)) 
                        {
                            
                            System.out.println("Enter email for confirmation :");
                            String email=sc.next();
                            System.out.println();
                            int screen=ShowController.addScreen(movie_name);
                            String time=ShowController.addTime(movie_name);
                            LocalDate b_date=LocalDate.now();
                            
                            Date m_date=ShowController.addDate(movie_name);
                            int unitprice=ShowController.addPrice(movie_name);
                            int price=n*unitprice;
                            try
		                    {
		                        boolean ad=ShowController.addToBill(email,movie_name,m_date,time,screen,b_date,price);
		                        boolean cd=ShowController.addTocBill(email,movie_name,m_date,time,screen,price);
		                        List<C_Bill> cbillList = ShowController.viewcBills();;
		                        if (!cbillList.isEmpty()) 
		                        {
		                            System.out.println("--Here's your bill-- ");
		                            for (C_Bill ve : cbillList)
		                                System.out.println(ve);
		                        }
		                        if(ad && cd) {
		                        	boolean uc=ShowController.deleteTable();
		                        	if(uc)
		                        	System.out.println(" Ticket booked ----- Enjoy your movie");
		                        }
		                    }
		                    catch(Exception e)
		                    {
		                        System.out.println("Failed to add to bill.");
		                    }
                            
                        }
                        //else    System.out.println("House full");
                    }
                    catch(Exception e)
                    {
                        System.out.println("House full");
                    }
                    break;
                case 3:
                	List<Snack> snacksList = EmployeeController.viewAllSnacks();;
                    if (!snacksList.isEmpty()) 
                    {
                        System.out.println("--List of Snacks--");
                        for (Snack ve : snacksList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Snacks found.");
                    System.out.print("Enter snack name :");
                    String name=sc.nextLine();
                    System.out.print("Enter quantity :");
                    int quantity=sc.nextInt();
                    int unitprice=ShowController.addsnackPrice(name);
                    int price=quantity*unitprice;
                    
                    System.out.print("--Total amount : "+price+" --");
                	break;	
                case 4:
                    System.out.print("--Nandri--");
                    b=false;
                    break;
            }
        }
        while(b);
    } 
}
