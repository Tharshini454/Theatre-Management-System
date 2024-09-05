package Model;


public class Show {
	private String movie_name;
    private String date;
    private String time;
    private int screen;
    private int seats;
    private int price;
    
    public Show(String movie_name,String date, String time,int screen,int seats,int price) 
    {
        this.movie_name = movie_name;
        this.date = date;
        this.time = time;
        this.screen = screen;
        this.seats = seats;
        this.price = price;
    }
    public int getScreen() {
        return screen;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
    public int getPrice() {
        return price;
    }
    public String toString() {
        return "" +
                " movie_name=' " + movie_name + '\'' +
                " , date='" + date + '\'' +
                " , time='" + time + '\'' +
                 " , screen='" + screen + '\'' +
                  " , avail_seats='" + seats + '\'' +
                " , price=" + price;
    }

}
