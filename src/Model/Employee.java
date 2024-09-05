package Model;

public class Employee {

	private int id;
    private String email;
    private String name;
    private int age;
    
    public Employee(int id,String email, String name,int age) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public String toString() {
        return ""
        		+ "" +
                " id=' " + id + '\'' +
                " , name='" + name + '\'' +
                " , email='" + email + '\'' +
                " , Age=" + age;
    }
}
