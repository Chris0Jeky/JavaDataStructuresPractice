import java.security.Key;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        HashMap<String, HashMapPhoneBook> phoneBook = new HashMap<>();
        main.addEntry("Boh", "+22 11 9922929", phoneBook);

        HashMapPhoneBook boh = phoneBook.get("Boh");
        System.out.println(boh.getName());

        Scanner scan = new Scanner(System.in);
        System.out.println("INSERT NAME: \n");
        String inputName = scan.nextLine();
        System.out.println("INSERT NUMBER: \n");
        String inputNumber = scan.next();
        main.addEntry(inputName, inputNumber, phoneBook);

        HashMapPhoneBook entry = phoneBook.get(inputName);
        System.out.println(entry.getName());
        main.printHash(phoneBook);
    }

    void addEntry(String name, String phoneNumber, HashMap<String, HashMapPhoneBook> phoneBook) {
        HashMapPhoneBook entry = new HashMapPhoneBook(name, phoneNumber);
        phoneBook.put(name, entry);
    }

    void printHash(HashMap<String, HashMapPhoneBook> phoneBook) {
        for (String key : phoneBook.keySet()) {
            System.out.println("Key: " + key + " Number: " + phoneBook.get(key).getPhoneNumber());
        }
    }




}


