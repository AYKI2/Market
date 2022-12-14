package service.impl;

import classes.Market;
import classes.Person;
import enums.Categories;
import enums.Markets;
import enums.Products;
import service.MarketService;

import java.math.BigDecimal;
import java.util.*;

public class MarketServiceImpl implements MarketService {
    private static List<Person> personList = new ArrayList<>();
    private static List<Market> marketList = new ArrayList<>();

    public static List<Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(List<Person> personList) {
        MarketServiceImpl.personList = personList;
    }

    public static List<Market> getMarketList() {
        return marketList;
    }

    public static void setMarketList(List<Market> marketList) {
        MarketServiceImpl.marketList = marketList;
    }

    @Override
    public String addDB(List<Market> markets) {
        PersonServiceImpl personService = new PersonServiceImpl();
        marketList = markets;
        personList.addAll(personService.getAllPerson());
        return "Successfully created!";
    }

    @Override
    public String market(List<Person> personList, int id) {
        List<String> list = new ArrayList<>();
        int amount = 0;
        for (Person person : personList) {
            if (person.getId() == id) {
                for (Markets markets : Markets.values()) {
                    for (Categories categories : markets.getCategories()) {
                        System.out.print(markets.name() + "[" + categories.name() + "]" + "\n");
                    }
                }
                System.out.println("Choice market: ");
                String market = new Scanner(System.in).next().toUpperCase();
                for (Markets markets : Markets.values()) {
                    if (markets.name().equals(market)) {
                        for (Categories categories : markets.getCategories()) {
                            boolean isTrue = true;
                            while (isTrue) {
                                System.out.println(markets.getCategories());
                                System.out.println("What do you want to buy?");
                                String product = new Scanner(System.in).nextLine().toUpperCase();
                                System.out.print("Quantity: ");
                                int qnt = new Scanner(System.in).nextInt();
                                for (Products products : categories.getProducts()) {
                                    if (products.name().equals(product) && products.getAmount() >= qnt) {
                                        int q = products.getPrice() * qnt;
                                        amount += q;
                                        if (q <= person.getWallet().intValue()) {
                                            int summa = person.getWallet().intValue() - q;
                                            person.setWallet(BigDecimal.valueOf(summa));
                                            int profit = markets.getWallet().intValue() + q;
                                            markets.setWallet(BigDecimal.valueOf(profit));
                                            int amo = products.getAmount() - qnt;
                                            products.setAmount(amo);
                                            list.add(products.name());
                                        } else {
                                            System.out.println("Not enough money!");
                                        }
                                    }
                                }
                                System.out.println("Want to buy something else? -> y/n");
                                String choice = new Scanner(System.in).next();
                                if (!choice.equals("y")) {
                                    List<String> che = new ArrayList<>();
                                    String check = "----------Check----------" + "\nPerson: " + person.getName() + "\nMarket: " + markets.name() + "\nShopping list: " + list + " " + qnt + "\nSumma: " + amount;
                                    che.add(check);
                                    if (person.getChecks().size() > 0) {
                                        for (String str : person.getChecks()) {
                                            str = check;
                                            System.out.println(str);
                                        }
                                    } else {
                                        person.setChecks(che);
                                        System.out.println(che);
                                    }
                                    isTrue = false;
                                    return "Purchase successful!";
                                }
                            }
                        }
                    }
                }
            }
        }
        return "Purchase not successful!";
    }

    @Override
    public String createMarket() {
        return null;
    }

    @Override
    public String RemoveMarket() {
        return null;
    }

    @Override
    public String changeMarket() {
        return null;
    }
}
