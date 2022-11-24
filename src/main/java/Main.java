import java.util.Scanner;

public class Main {

    private static Coffee[] coffeesInMenu = new Coffee[] { new Espresso('S'), new Macchiato('S'), new Latte('S'), new Cappuccino('S'), new Mocha('S') };
    private static Scanner userInput = new Scanner(System.in);

    public static void printMenu() {
        String menuString = "----------------Welcome to Java Express----------------\n";
        menuString += "-------------------------------------------------------\n";
        menuString +=  String.format("%25s%12s%12s", "SMALL", "MEDIUM", "LARGE") + "\n";
        menuString += "-------------------------------------------------------\n";
        for (int i = 0; i < coffeesInMenu.length; i++) {
            menuString += String.format("%d. %12s %8.2f %10.2f %12.2f", (i + 1), coffeesInMenu[i].getName(),
                            coffeesInMenu[i].calculateCost('S'), coffeesInMenu[i].calculateCost('M'),
                            coffeesInMenu[i].calculateCost('L')) + "\n";
        }
        menuString += "-------------------------------------------------------";
        System.out.println(menuString);
    }

    // userSelection method
    public static Coffee coffeeSelection() {
        System.out.println("Please enter a number 1 - 5");
        String coffeeChoice = userInput.nextLine();

        System.out.println("Please enter the size: S, M or L");
        String coffeeSize = userInput.nextLine();
        
        char choice = coffeeSize.charAt(0);
        switch (coffeeChoice) {
            case "1":
                return new Espresso(choice);
            case "2":
                return new Macchiato(choice);
            case "3":
                return new Latte(choice);
            case "4":
                return new Cappuccino(choice);
            case "5":
                return new Mocha(choice);
            default:
                System.out.println("Choice was not recognised");
        }
        return null;
    }

    public static void drinkCoffee(User user){
        if (user.isHasCoffee()) {
            if (user.getCoffees().size() > 1) {
                System.out.println(String.format("Which coffee would you like to drink:"));
                for (Coffee coffee:user.getCoffees()) {
                    System.out.println(coffee.getName());
                }
                String choice = userInput.nextLine();

            }
            System.out.println(String.format("%s drinks their coffee", user.getName()));
            user.setHasCoffee(false);
        } else {
            System.out.println(String.format("Sorry %s, you don't have any coffee...", user.getName()));
        }
    }

    // generateReceipt method
    public static String generateReceipt(User user, Coffee coffee){
        if (!affordable(user, coffee)) {
            return "You can't afford this coffee.";
        } else {
            String receiptString = String.format("-------------The Coffee Receipt for %s-------------\n", user.getName());
            receiptString += "---------------------------------------------------\n";
            receiptString += String.format("Coffee: %s(%s)", coffee.getName(), coffee.getSize());
            receiptString += String.format("\nThe cost is: £%s", (Math.round(coffee.calculateCost(coffee.getSize()) * 100.0) / 100.0 ));
            user.coffees.add(coffee);
            user.setHasCoffee(true);
            return receiptString;
        }
    }

    public static boolean affordable(User user, Coffee coffee){
        double balance = user.getBalance();
        balance = Math.round(balance * 100.0) / 100.0;
        if (balance < coffee.calculateCost(coffee.getSize())) {
            return false;
        } else {
            double required = balance - coffee.calculateCost(coffee.getSize());
            user.setBalance(required);
            return true;
        }
    }

    public static void menuSelection(User user){
        System.out.println(String.format("-------------What would you like to do %s?-------------\n", user.getName()));
        System.out.println("-------------------------------------------------------\n");
        System.out.println("1. Buy Coffee\n" +
                "2. Drink Coffee\n" +
                "3. Check Balance\n" +
                "4. Leave Cafe");

        String menuChoice = userInput.nextLine();
        switch (menuChoice) {
            case "1":
                printMenu();
                System.out.println(generateReceipt(user, coffeeSelection()));
                menuSelection(user);
                break;
            case "2":
                drinkCoffee(user);
                menuSelection(user);
                break;
            case "3":
                checkBalance(user);
                menuSelection(user);
                break;
            case "4":
                System.out.println("See you again!");
                break;
        }
    }

    public static void checkBalance(User user) {
        Double balance = user.getBalance();
        balance.toString();
        System.out.println(String.format("Your current balance: £%s", balance));
    }

    public static void main(String[] args) {
        User user = new User();

        System.out.println("Please enter your name: ");
        String name = userInput.nextLine();
        user.setName(name);
        user.setId(1L);
        user.setBalance(10);

        menuSelection(user);


    }

}
