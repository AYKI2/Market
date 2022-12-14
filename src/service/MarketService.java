package service;

import classes.Market;
import classes.Person;

import java.util.List;

public interface MarketService {
    String addDB(List<Market> markets);
    String market(List<Person>personList, int id);
    String createMarket();
    String RemoveMarket();
    String changeMarket();
}
