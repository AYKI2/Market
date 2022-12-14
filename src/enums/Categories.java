package enums;

import java.util.List;

public enum Categories {
    MEAT(List.of(Products.BEEF,Products.CHICKEN,Products.MUTTON,Products.SAUSAGE)),
    VEGETABLES(List.of(Products.POTATO,Products.CARROT,Products.ONION,
            Products.TOMATO,Products.CUCUMBER)),
    FRUITS_AND_BERRIES(List.of(Products.APPLE,Products.BANANA,Products.CHERRY,
            Products.LEMON,Products.ORANGE, Products.WATERMELON,Products.MELON,
            Products.MANDARIN,Products.RASPBERRY)),
    DAIRY(List.of(Products.EGG,Products.CHEESE,Products.BUTTER,Products.MILK,
            Products.YOGURT,Products.SOUR_CREAM,Products.ICE_CREAM,Products.DRIED_MILK)),
    DESSERTS_AND_SWEETS(List.of(Products.COOKIE,Products.CANDY,Products.CHOCOLATE,
            Products.HONEY,Products.CAKE));

    List<Products> products;

    Categories(List<Products> products) {
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nproducts = " + products ;
    }
}
