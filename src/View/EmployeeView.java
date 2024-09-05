package View;
import java.util.*;



import Controller.EmployeeController;
import Controller.SnackController;
import Model.Snack;
public class EmployeeView 
{
    static Scanner sc=new Scanner(System.in);
    public static void menu()
    
    {
        boolean b=true;
        do
        {
            System.out.println();
            System.out.println(" 1.Display snack details \n 2.Add Snack \n 3.Update Snack \n  4.Exit");
            System.out.println();
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            switch(a)
            {
//                case 1:
//                    break;
                case 1:
                	List<Snack> snacksList = EmployeeController.viewAllSnacks();;
                    if (!snacksList.isEmpty()) 
                    {
                        System.out.println("--List of Snacks--");
                        for (Snack ve : snacksList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Snacks found.");
                    break;
                case 2:
                	System.out.print("Enter snack id: ");
                    int s_id = sc.nextInt();
                    System.out.print("Enter snack name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter price : ");
                    int price = sc.nextInt();
                    try
                    
                    
                    {
                        // boolean ad=AdminFunction.addManager(email,password,name,designation);
                        boolean uc=SnackController.addSnack(s_id, name,quantity,price);
                        if(uc)  System.out.println("A new snack has been inserted into the database.");
                        else    
                        System.out.println("Failed to insert snack into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert snack into the database.");
                    }
                    break;    
                case 3:
                	System.out.print("Enter snack name: ");
                	String snack_name=sc.nextLine();
                	System.out.print("Enter new_quantity: ");
                	int new_quantity=sc.nextInt();
                	try {
                		if(SnackController.updateSnack(new_quantity,snack_name)) {
                			System.out.print("Snacks has been updated");
                		}
                		else {
                			System.out.println("Error during updating");
                		}
                	}
                	catch(Exception e){
                		System.out.println("Error during updating snacks!");
                	}
                	
                	break;
                	
                case 4:
                    System.out.println();
                    System.out.println("--Nandrii--");
                    System.out.println();
                    b=false;
                    break;
            }
            
        }
        while(b);
    } 
}
