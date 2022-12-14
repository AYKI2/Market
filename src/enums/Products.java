package enums;

public enum Products {
    BEEF(200,5),
    CHICKEN(180,5),
    MUTTON(150,5),
    SAUSAGE(120,5),
    POTATO(25,10),
    CARROT(25,10),
    ONION(25,10),
    TOMATO(25,10),
    CUCUMBER(25,10),
    APPLE(15,5),
    BANANA(15,5),
    CHERRY(15,25),
    LEMON(20,10),
    ORANGE(25,25),
    WATERMELON(150,5),
    MELON(150,5),
    MANDARIN(15,25),
    RASPBERRY(25,20),
    EGG(12,25),
    CHEESE(120,10),
    BUTTER(50,5),
    MILK(80,5),
    YOGURT(25,10),
    SOUR_CREAM(120,5),
    ICE_CREAM(35,10),
    DRIED_MILK(120,5),
    COOKIE(100,10),
    CANDY(100,10),
    CHOCOLATE(80,5),
    HONEY(120,5),
    CAKE(200,5);

    int price;
    int amount;

    Products(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  super.toString()
                + " price = " + price +
                " quantity = " + amount + "\n";
    }
}
