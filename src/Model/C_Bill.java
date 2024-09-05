package Model;

import java.sql.Date;

public class C_Bill {


    private String email;
    private String movie_name;
    private Date m_date;
    private String time;
    private int screen;
    private int price;
   
    
    public C_Bill(String email ,String movie_name,Date m_date,String time,int screen,int price) 
    {

        this.movie_name = movie_name;
        this.email = email;
        this.m_date= m_date;
        this.time=time;
        this.screen=screen;
        this.price = price;
     
        
    }
    public String toString() {
        return "" +
                " m_date= " + m_date  +
                " \n movie_name= " + movie_name  +
                " \n email= " + email +
                " \n time= " + time +
                " \n screen= "+ screen +
                " \n price= "+price ;
    }
    
}
