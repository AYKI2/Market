package service;

import classes.Person;
import enums.Products;

import java.util.List;
import java.util.Map;

public interface PersonService {
    String addDB(List<Person> people);
    String createPerson();
    String removePerson(String name);
    List<Person> findByName(String name);
    List<Person> getAllPerson();
    String addProduct(int id);
    String removeProduct(int id);
    Map<String, Integer> getList(int id);
    Map<String, Integer> findProduct(int id);
    String changeProfile(int id);
}
