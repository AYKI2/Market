package service.impl;

import classes.Person;
import exceptions.newException;
import service.PersonService;

import java.math.BigDecimal;
import java.util.*;

public class PersonServiceImpl implements PersonService {
    private static List<Person> personList = new ArrayList<>();

    public static List<Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(List<Person> personList) {
        PersonServiceImpl.personList = personList;
    }

    @Override
    public String addDB(List<Person> people) {
        personList = people;
        return "Successfully created!";
    }

    @Override
    public String createPerson() {
        try {
            System.out.print("\nIDs that already exist: ");
            for (Person person : personList) {
                System.out.print(person.getId() + ", ");
            }
            System.out.print("\nEnter ID: ");
            int id = new Scanner(System.in).nextInt();
            for (Person person : personList) {
                if (person.getId() == id) {
                    throw new newException("\nThis ID already exists!");
                }
            }
            System.out.print("\nWrite your name: ");
            String name = new Scanner(System.in).nextLine();
            if (!name.matches("[a-zA-Z]*")) {
                throw new newException("\nName entered incorrectly (only letters)!");
            }
            System.out.print("\nWrite your age: ");
            int age = new Scanner(System.in).nextInt();
            if (age < 0 || age > 120){
                throw new newException("wrong age entry!");
            }
            System.out.print("\nWallet balance: ");
            BigDecimal wallet =new Scanner(System.in).nextBigDecimal();
            int wallet1 = wallet.intValue();
            if (wallet1 < 0){
                throw new newException("Balance cannot be negative!");
            }
            System.out.println("Create password: ");
            String password = new Scanner(System.in).nextLine();
            if (password.isEmpty() || password.length() > 10){
                throw new newException("The password must not be empty and its size must be less than 11!");
            }
            System.out.println("Create shopping list? -> y/n");
            String choice = new Scanner(System.in).next().toLowerCase();
            Map<String,Integer> shoppingList = new LinkedHashMap<>();
            if (choice.equals("y") || choice.equals("yes")) {
                boolean isTrue = true;
                try {
                    while (isTrue) {
                        System.out.print("\nWrite the name of the product: ");
                        String product = new Scanner(System.in).nextLine();
                        if (product.matches("[a-zA-Z -]*]")) {
                            System.out.println("Product name entered incorrectly");
                            throw new newException("Product name entered incorrectly");
                        }
                        System.out.print("Quantity: ");
                        int quantity = new Scanner(System.in).nextInt();
                        if (quantity < 0 || quantity > 200){
                            System.out.println("Quantity cannot be negative or greater than 200!");
                            throw new newException("Quantity cannot be negative or greater than 200!");
                        }
                        shoppingList.put(product,quantity);
                        System.out.println("\nDo you want to add something else? -> y/n");
                        String choice2 = new Scanner(System.in).next().toLowerCase();
                        if (choice2.equals("n") || choice2.equals("no")){
                            isTrue = false;
                        }
                    }
                    List<String>checks = new ArrayList<>();
                    Person person = new Person(id,name,age,wallet,password,shoppingList,checks);
                    personList.add(person);
                }catch (newException e){
                    e.getMessage();
                }catch (InputMismatchException e){
                    System.out.println("Wrong input!(When added to sheet).");
                }
            }
            return "Successfully created!";
        }catch (InputMismatchException e){
            System.out.println("Wrong input!");
        } catch (newException e) {
            e.getMessage();
        }
        return "Created failed!";
    }

    @Override
    public String removePerson(String name) {
        boolean isRemoved = personList.removeIf(person -> person.getName().equals(name));
        return isRemoved ? "Person successfully removed!" : "Person remove failed!";
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> personList1 = new ArrayList<>();
        if(name.matches("[a-zA-Z ]*")){
            for (Person person : personList) {
                if (person.getName().equals(name)) {
                    personList1.add(person);
                }
            }
        }else {
            System.out.println("Incorrect input!");
        }
        return personList1;
    }

    @Override
    public List<Person> getAllPerson() {
        return personList;
    }

    @Override
    public String addProduct(int id) {
        boolean isAdded = false;
        for (Person person : personList) {
            if (person.getId() == id){
                System.out.print("\nEnter product name: ");
                String product = new Scanner(System.in).nextLine();
                System.out.print("\nEnter quantity: ");
                Integer qnt = new Scanner(System.in).nextInt();
                person.getShoppingList().put(product,qnt);
                isAdded = true;
            }
        }
        if(isAdded) {
            return "Successfully added!";
        }else {
            return "Add failed!";
        }
    }

    @Override
    public String removeProduct(int id) {
        boolean isRemoved = false;
        for (Person person : personList) {
            if(person.getId() == id) {
                System.out.println("Write product name: ");
                String product = new Scanner(System.in).nextLine();
                person.getShoppingList().remove(product);
                for (Map.Entry<String, Integer> entry : person.getShoppingList().entrySet()) {
                    if (!entry.getKey().equals(product)) {
                        isRemoved = true;
                    }
                }
            }
        }
        return isRemoved ? "Product successfully removed!" : "Product remove failed!";
    }

    @Override
    public Map<String, Integer> getList(int id) {
        Map<String, Integer> list = new LinkedHashMap<>();
        for (Person person:personList) {
            if (person.getId() == id){
                list.putAll(person.getShoppingList());
            }
        }
        return list;
    }

    @Override
    public Map<String, Integer> findProduct(int id) {
        Map<String, Integer> list = new LinkedHashMap<>();
        for (Person person:personList) {
            if (person.getId() == id){
                System.out.print("Write product name: ");
                String product = new Scanner(System.in).nextLine();
                for (Map.Entry<String,Integer> entry:person.getShoppingList().entrySet()) {
                    if (entry.getKey().equals(product)){
                        list.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return list;
    }

    @Override
    public String changeProfile(int id) {
        boolean isKeep = false;
        for (Person person : personList) {
            if (person.getId() == id) {
                System.out.println("""
                        Choose what you want to change:
                        1 -> Replenish the balance,
                        2 -> Password,
                        3 -> Shopping list
                        """);
                int number = new Scanner(System.in).nextInt();
                int balance;
                switch (number) {
                    case 1:
                        System.out.print("Replenishment amount: ");
                        balance = new Scanner(System.in).nextInt();
                        balance += person.getWallet().intValue();
                        person.setWallet(BigDecimal.valueOf(balance));
                        isKeep = true;
                        break;
                    case 2:
                        System.out.print("\nEnter old password: ");
                        String password = new Scanner(System.in).nextLine();
                        if (person.getPassword().equals(password)) {
                            System.out.print("\nEnter new password: ");
                            String newPassword = new Scanner(System.in).nextLine();
                            System.out.println("Are you sure you want to change your password? -> y/n");
                            String choice = new Scanner(System.in).next();
                            if (choice.equals("y") || choice.equals("yes")) {
                                person.setPassword(newPassword);
                                isKeep = true;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Wrong password!");
                        }
                        break;
                    case 3:
                        System.out.println("""
                                What do you want to change?
                                1 -> Product,
                                2 -> Quantity
                                """);
                        int number1 = new Scanner(System.in).nextInt();
                        switch (number1) {
                            case 1:
                                System.out.println(person.getShoppingList());
                                System.out.println("Which product do you want to change?");
                                String product = new Scanner(System.in).nextLine();
                                for (Map.Entry<String, Integer> entry : person.getShoppingList().entrySet()) {
                                    if (entry.getKey().equals(product)) {
                                        System.out.println("What do you want to replace it with?");
                                        String product1 = new Scanner(System.in).nextLine();
                                        person.getShoppingList().replace(product1,entry.getValue());
                                        System.out.println(person.getShoppingList());
                                        isKeep = true;
                                    }
                                }
                                break;
                            case 2:
                                System.out.println(person.getShoppingList());
                                System.out.println("Which product quantity do you want to change?");
                                String product2 = new Scanner(System.in).nextLine();
                                for (Map.Entry<String, Integer> entry : person.getShoppingList().entrySet()) {
                                    if (entry.getKey().equals(product2)) {
                                        System.out.println("What to change?");
                                        Integer qnt = new Scanner(System.in).nextInt();
                                        person.getShoppingList().replace(product2, qnt);
                                        System.out.println(person.getShoppingList());
                                        isKeep = true;
                                    }
                                }
                                break;
                        }
                }
            }
        }
        if(isKeep) {
            return "Successfully changed!";
        }else {
            return "Change failed!";
        }
    }
}
