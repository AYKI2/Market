import classes.Market;
import classes.Person;
import enums.Markets;
import exceptions.newException;
import service.impl.MarketServiceImpl;
import service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.util.*;

class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static PersonServiceImpl personService = new PersonServiceImpl();
    public static MarketServiceImpl marketService = new MarketServiceImpl();

    public static void main(String[] args) {
        Map<String, Integer> list1 = new LinkedHashMap<>();
        Map<String, Integer> list2= new LinkedHashMap<>();
        Map<String, Integer> list3 = new LinkedHashMap<>();

        List<String> check1 = new ArrayList<>();
        List<String> check2 = new ArrayList<>();
        List<String> check3 = new ArrayList<>();

        Person person1 = new Person(1, "Iskhak", 20, new BigDecimal(2000), "qwe", list1,check1);
        Person person2 = new Person(2, "Dastan", 20, new BigDecimal(1000), "123", list2,check2);
        Person person3 = new Person(3, "Mukhammed", 18, new BigDecimal(1500), "123qwe", list3,check3);
        List<Person> people = new ArrayList<>(List.of(person1,person2,person3));
        List<Market> markets = new ArrayList<>();
        commands(people,markets);

    }

    public static void commands(List<Person> people, List<Market>markets) {
        boolean isTrue1 = true;
        int id = 0;
        String password = "";
        try {
            while (isTrue1) {
                System.out.println("""
                        1 -> Sign In,
                        2 -> Log In,
                        0 -> Stop
                        """);
                int numm = new Scanner(System.in).nextInt();
                boolean isTrue2 = true;
                while (isTrue2) {
                    switch (numm) {
                        case 1:
                            break;
                        case 2:
                            boolean isKeep = false;
                            if(people.size() > 0) {
                                System.out.print("Write your ID: ");
                                id = new Scanner(System.in).nextInt();
                                for (Person person : people) {
                                    if (person.getId() == id) {
                                        System.out.print("\nWrite your password: ");
                                        password = new Scanner(System.in).nextLine().toLowerCase();
                                        if (!person.getPassword().equals(password)) {
                                            System.out.println("Password entered incorrectly!");
                                            throw new newException("Password entered incorrectly!");
                                        } else {
                                            isKeep = true;
                                            break;
                                        }
                                    }
                                }if(isKeep) {
                                    System.out.println("""
                                            1 -> Person,
                                            2 -> Market,
                                            0 -> Logout
                                            """);
                                    int number = new Scanner(System.in).nextInt();
                                    if (number == 0) {
                                        isTrue2 = false;
                                    }
                                    boolean isTrue3 = true;
                                    while (isTrue3) {
                                        switch (number) {
                                            case 1:
                                                System.out.println("""
                                                        ---------------Person---------------
                                                        1 -> Add DataBase,
                                                        2 -> Create Person,
                                                        3 -> Remove Person,
                                                        4 -> Find By Name,
                                                        5 -> Show All Person,
                                                        6 -> Add Product,
                                                        7 -> Remove Product,
                                                        8 -> Show List,
                                                        9 -> Find Product,
                                                        10 -> Change Profile,
                                                        0 -> Exit
                                                        """);
                                                int num = new Scanner(System.in).nextInt();
                                                switch (num) {
                                                    case 1 -> System.out.println(personService.addDB(people));
                                                    case 2 -> System.out.println(personService.createPerson());
                                                    case 3 -> System.out.println(personService.removePerson(new Scanner(System.in).nextLine()));
                                                    case 4 -> System.out.println(personService.findByName(new Scanner(System.in).nextLine()));
                                                    case 5 -> System.out.println(personService.getAllPerson());
                                                    case 6 -> System.out.println(personService.addProduct(id));
                                                    case 7 -> System.out.println(personService.removeProduct(id));
                                                    case 8 -> System.out.println(personService.getList(id));
                                                    case 9 -> System.out.println(personService.findProduct(id));
                                                    case 10 -> System.out.println(personService.changeProfile(id));
                                                    case 0 -> isTrue3 = false;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("""
                                                        1 -> Add DataBase,
                                                        2 -> Market,
                                                        3 -> Create Market,
                                                        4 -> Remove Market,
                                                        5 -> Change Market,
                                                        6 -> Show All Markets,
                                                        0 -> Exit
                                                        """);
                                                int n = new Scanner(System.in).nextInt();
                                                switch (n) {
                                                    case 1 -> marketService.addDB(markets);
                                                    case 2 -> marketService.market(personService.getAllPerson(),id);
                                                    case 3 -> marketService.createMarket();
                                                    case 4 -> marketService.RemoveMarket();
                                                    case 5 -> marketService.changeMarket();
                                                    case 6 -> System.out.println(Arrays.toString(Markets.values()));
                                                    case 0 -> isTrue3 = false;
                                                }
                                                break;
                                            case 0:
                                                isTrue3 = false;
                                                break;
                                            default:
                                                System.out.println("No such number!");
                                                break;
                                        }
                                    }
                                }else {
                                    System.out.println("Login failed!");
                                    break;
                                }
                            }else {
                                System.out.println("DataBase is empty!");
                            }
                            break;
                        case 0:
                            isTrue2 = false;
                            break;
                        default:
                            System.out.println("No such number!");
                            break;
                    }
                }
                if (numm == 0){
                    isTrue1 =false;
                }
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }catch (newException e){
            e.getMessage();
        }
    }
}