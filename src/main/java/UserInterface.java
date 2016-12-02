import java.util.Scanner;

public class UserInterface {
    private static UserInterface userInterface;
    private DataBaseControl dataBaseControl = DataBaseControl.getInstance();
    private Scanner scanner;
    private int option;
    private boolean flag = false;

    static {
        userInterface = new UserInterface();
    }

    private UserInterface() {

    }

    public static UserInterface getInstance() {
        return userInterface;
    }

    public void getInterface(Scanner scanner) {
        this.scanner = scanner;
        while (!flag) {
            printMenu();
            scanResult();
            switchMenu();
        }
    }

    private void printMenu() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Choose option from 0 to 6:                                |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| 1.Print all apartments.                                   |");
        System.out.println("| 2.Print apartments within price range.                    |");
        System.out.println("| 3.Print apartments with certain number of rooms.          |");
        System.out.println("| 4.Print apartments in certain district.                   |");
        System.out.println("| 5.Print apartments within area range.                     |");
        System.out.println("| 6.Add apartment to base.                                  |");
        System.out.println("| 0.Exit.                                                   |");
        System.out.println("+-----------------------------------------------------------+");
    }

    private void scanResult() {
        while (true) {
            String temp = scanner.nextLine();
            if ((temp.equals("0") || temp.equals("1") || temp.equals("2") || temp.equals("3") ||
                    temp.equals("4") || temp.equals("5") || temp.equals("6"))) {
                option = Integer.parseInt(temp);
                return;
            } else {
                System.out.println("Choose from 0 to 6.");
            }
        }
    }

    private void switchMenu() {
        switch (option) {
            case 0: {
                flag = true;
                break;
            }
            case 1: {
                printAll();
                break;
            }
            case 2: {
                printWithinPrice();
                break;
            }
            case 3: {
                printWithRooms();
                break;
            }
            case 4: {
                printInDistrict();
                break;
            }
            case 5: {
                printWithArea();
                break;
            }
            case 6: {
                addToBase();
                break;
            }
        }
    }

    private void printAll() {
        dataBaseControl.printAll();
    }

    private void printWithArea() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Enter the highest area possible:                          |");
        int highest = Integer.parseInt(scanner.nextLine());
        System.out.println("| Enter the lowest area possible:                           |");
        int lowest = Integer.parseInt(scanner.nextLine());
        dataBaseControl.printWithArea(lowest, highest);
    }

    private void printWithinPrice() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Enter the highest price possible:                         |");
        int highest = Integer.parseInt(scanner.nextLine());
        System.out.println("| Enter the lowest price possible:                          |");
        int lowest = Integer.parseInt(scanner.nextLine());
        dataBaseControl.printWithinPrice(lowest, highest);
    }

    private void printWithRooms() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Enter amount of rooms:                                    |");
        int rooms = Integer.parseInt(scanner.nextLine());
        dataBaseControl.printWithRooms(rooms);
    }

    private void printInDistrict() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Enter name of a district:                                 |");
        String district = scanner.nextLine();
        dataBaseControl.printInDistrict(district);
    }

    private void addToBase() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Enter number of rooms:                                    |");
        int rooms = Integer.parseInt(scanner.nextLine());
        System.out.println("| Enter area of apartment:                                  |");
        int area = Integer.parseInt(scanner.nextLine());
        System.out.println("| Enter name of a district:                                 |");
        String district = scanner.nextLine();
        System.out.println("| Enter address:                                            |");
        String address = scanner.nextLine();
        System.out.println("| Enter price:                                              |");
        int price = Integer.parseInt(scanner.nextLine());
        dataBaseControl.addToBase(rooms, area, district, address, price);
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("| Apartment added to base.                                  |");
        System.out.println("+-----------------------------------------------------------+");
    }
}
