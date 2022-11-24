import java.util.ArrayList;

public class User {

    private Long id;
    private String name;
    private double balance;
    private boolean hasCoffee;
    ArrayList<Coffee> coffees;

    public User(Long id, String name, double balance, boolean hasCoffee) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.hasCoffee = hasCoffee;
        this.coffees = new ArrayList<>();
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isHasCoffee() {
        return hasCoffee;
    }

    public void setHasCoffee(boolean hasCoffee) {
        this.hasCoffee = hasCoffee;
    }

    public ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(ArrayList<Coffee> coffees) {
        this.coffees = coffees;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
