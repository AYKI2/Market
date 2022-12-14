package classes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Person {
    private int id;
    private String name;
    private int age;
    private BigDecimal wallet;
    private String password;
    private Map<String, Integer> shoppingList;
    private List<String> checks;

    public Person() {
    }

    public Person(int id, String name, int age, BigDecimal wallet, String password, Map<String, Integer> shoppingList,List<String> checks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wallet = wallet;
        this.password = password;
        this.shoppingList = shoppingList;
        this.checks = checks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Integer> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Map<String, Integer> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<String> getChecks() {
        return checks;
    }

    public void setChecks(List<String> checks) {
        this.checks = checks;
    }

    @Override
    public String toString() {
        return "Person: " +
                "\nid = " + id +
                "\nname = " + name +
                "\nage = " + age +
                "\nwallet = " + wallet +
                "\npassword = " + password +
                "\nshoppingList = " + shoppingList +
                "\nlist of checks = "+checks+"\n";
    }
}
