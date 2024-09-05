package Model;

import java.sql.Date;

public class Bill {


    private String email;
    private String movie_name;
    private Date m_date;
    private String time;
    private int screen;
    private Date b_date;
    private int price;
    
    public Bill(String email ,String movie_name,Date m_date,String time,int screen,Date b_date,int price) 
    {

        this.movie_name = movie_name;
        this.email = email;
        this.m_date= m_date;
        this.time=time;
        this.screen=screen;
        this.b_date = b_date;
        this.price = price;
    }
    public String toString() {
        return "" +
                " m_date=' " + m_date + '\'' +
                " , movie_name='" + movie_name + '\'' +
                " , email='" + email + '\'' +
                " , time=" + time + '\''+
                ",  screen="+ screen + '\''+
                ",  b_date="+ b_date + '\''+
                ", price="+price ;
    }
    
}
