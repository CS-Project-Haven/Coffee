public abstract class Coffee {

    private String name;
    private CoffeeType coffeeType;
    private boolean withMilk;
    private char size;
    private double basePrice;

    public Coffee(String name, CoffeeType coffeeType, boolean withMilk, char size, double basePrice) {
        this.name = name;
        this.coffeeType = coffeeType;
        this.withMilk = withMilk;
        this.size = size;
        this.basePrice = basePrice;
    }

    public Coffee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public boolean isWithMilk() {
        return withMilk;
    }

    public void setWithMilk(boolean withMilk) {
        this.withMilk = withMilk;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                '}';
    }

    public final double calculateCost(char size) {
        double cost = getBasePrice();

        if (size == 'S') {
            return cost * 1.1;
        }
        else if (size == 'M') {
            return cost * 1.25;
        }
        else if (size == 'L') {
            return cost * 1.75;
        }
        return 0;
    }
}

class Espresso extends Coffee {

    public Espresso(char s) {
        setName("Espresso");
        setCoffeeType(CoffeeType.STRONG);
        setWithMilk(false);
        setBasePrice(2.4);
        setSize(s);
    }
}

class Macchiato extends Coffee {

    public Macchiato(char s) {
        setName("Macchiato");
        setCoffeeType(CoffeeType.STRONG);
        setWithMilk(true);
        setBasePrice(3.7);
        setSize(s);
    }
}

class Latte extends Coffee {

    public Latte(char s) {
        setName("Latte");
        setCoffeeType(CoffeeType.SMOOTH);
        setWithMilk(true);
        setBasePrice(4.2);
        setSize(s);
    }

}

class Mocha extends Latte {

    private Boolean withChocolate;

    public Mocha(char s) {
        super(s);
        setName("Mocha");
        setCoffeeType(CoffeeType.SMOOTH);
        setWithMilk(true);
        setBasePrice(4.5);
        setSize(s);
        setWithChocolate(true);
    }

    public boolean isWithChocolate() {
        return withChocolate;
    }

    public void setWithChocolate(Boolean withChocolate) {
        this.withChocolate = withChocolate;
    }
}

class Cappuccino extends Coffee {

    public Cappuccino(char s) {
        setName("Cappuccino");
        setCoffeeType(CoffeeType.SMOOTH);
        setWithMilk(true);
        setBasePrice(4.3);
        setSize(s);
    }
}