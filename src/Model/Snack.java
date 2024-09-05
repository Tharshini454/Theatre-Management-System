package Model;

public class Snack {

	private int id;
    private String name;
    private int quantity; 
    private int price;
    
    public Snack(int id, String name,int quantity,int price) 
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price=price;
    }
    public String toString() {
        return "" +
                " id= " + id  +
                " name=" + name + '\n' +
                " quantity=" + quantity + '\n' +
                " price=" + price ;
    }
}
