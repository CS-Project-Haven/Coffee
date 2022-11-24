import org.junit.jupiter.api.Test;

public class Testing {

    User user = new User(21L, "Joe", 10,  true);
    Coffee userCoffee = new Latte('L');

    @Test
    void balanceTest() {
        Main.printMenu();
        Main.checkBalance(user);
        System.out.println(Main.generateReceipt(user, userCoffee));
        double balance = user.getBalance();
        balance = balance - userCoffee.calculateCost(userCoffee.getSize());
        balance = Math.round(balance * 100.0) / 100.0;
        user.setBalance(balance);
        Main.checkBalance(user);
    }

    @Test
    void userHasCoffee() {
        Main.drinkCoffee(user);
    }
}
