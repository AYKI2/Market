package classes;

import enums.Categories;
import enums.Products;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Market {
    private String name;
    private List<Categories> products;
    private BigDecimal wallet;

    public Market() {
    }

    public Market(String name, List<Categories> products, BigDecimal wallet) {
        this.name = name;
        this.products = products;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Categories> getProducts() {
        return products;
    }

    public void setProducts(List<Categories> products) {
        this.products = products;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Market: " +
                "\nname = " + name +
                "\nproducts = " + products +
                "\nwallet = " + wallet + "\n";
    }
}
