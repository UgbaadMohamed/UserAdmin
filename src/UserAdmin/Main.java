package UserAdmin;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner fileScanner= null;
    File file = new File("text.txt");
    PrintStream printStream = null;
    private ArrayList<User> users;

    Main() {
        users = new ArrayList<User>();
        readFile();
    }

    void viewUserList() {
        System.out.println("\nUSER LIST:");
        for (int i = 0; i < users.size(); i++)
            System.out.println("#" + i + ": " + users.get(i));
    }

    void createNewUser() {
        int id;
        String name;
        String password;
        User user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCREATE NEW USER\n");
        System.out.print("Id: ");
        id = scanner.nextInt();
        scanner.nextLine(); //Scanner bug
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        user = new User(id, name, password);
        users.add(user);
        saveFile();
        System.out.println("\nUser added.");
    }

    void deleteUser() {
        int userNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDELETE USER:");
        System.out.print("Enter # of user to delete: ");
        userNumber = scanner.nextInt();
        users.remove(userNumber);
        saveFile();
        System.out.println("\nUser deleted.");
    }

    void readFile() {
            try {
                fileScanner = new Scanner(new File("User.txt"));
                while (fileScanner.hasNextLine()) {
                    String ffr = fileScanner.nextLine();
                    System.out.println(ffr);
                }

                fileScanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    void saveFile() {

        //Implement this ...
    }


    void run() {
        boolean running;
        Menu menu = new Menu("MENU:", "Please choose option: ", new String[] {
                "1. View user list",
                "2. Create new user",
                "3. Delete user",
                "9. Quit"
        });

        readFile();

        running = true;

        while (running) {
            menu.printMenu();
            int userChoice = menu.readChoice();
            switch (userChoice ) {
                case 1:
                    viewUserList();
                    break;

                case 2:
                    createNewUser();
                    break;

                case 3:
                    deleteUser();
                    break;

                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("\nIllegal choice.");
            }
        }
    }
    public static void main(String[] args) {
        new Main().run();

    }
}






