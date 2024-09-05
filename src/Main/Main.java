package Main;
import java.util.*;
// import Controller.*;
import View.*;
public class Main
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
        boolean b=true;
        do
        {
        	System.out.println();
            System.out.println("Press 1 for login   ");
            System.out.println("Press 2 for Sign up  ");
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1)
            {
                UserView.loginPage();
                // UserController.checkLogin();
            }
            else if(n==2)
            {
                UserView.signin();
            }
            else
                System.out.println("-- Enter only 1 || 2 -- ");
        }
        while(b);
    }
}