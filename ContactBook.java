// Task 5: Simple Contact Book
// Saiket Systems Internship
// Student Project

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;
    
    Contact(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }
    
    void show() {
        System.out.println("Name:  " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

public class ContactBook {
    static ArrayList<Contact> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   CONTACT BOOK APPLICATION");
        System.out.println("   Saiket Systems Internship");
        System.out.println("========================================\n");
        
        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("==========================");
            System.out.print("\nEnter your choice (1-5): ");
            
            String ch = sc.nextLine();
            
            switch (ch) {
                case "1":
                    add(sc);
                    break;
                case "2":
                    view();
                    break;
                case "3":
                    search(sc);
                    break;
                case "4":
                    delete(sc);
                    break;
                case "5":
                    System.out.println("\n========================================");
                    System.out.println("Thank you for using Contact Book!");
                    System.out.println("Total contacts: " + list.size());
                    System.out.println("#SaiKetSystemsJourney");
                    System.out.println("========================================\n");
                    sc.close();
                    return;
                default:
                    System.out.println("\nInvalid choice!");
            }
        }
    }
    
    public static void add(Scanner sc) {
        System.out.println("\n--- ADD NEW CONTACT ---");
        System.out.print("Enter Name: ");
        String n = sc.nextLine().trim();
        System.out.print("Enter Phone: ");
        String p = sc.nextLine().trim();
        System.out.print("Enter Email: ");
        String e = sc.nextLine().trim();
        
        list.add(new Contact(n, p, e));
        System.out.println("\nContact added!");
    }
    
    public static void view() {
        if (list.isEmpty()) {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("   ALL CONTACTS (" + list.size() + ")");
        System.out.println("========================================");
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            list.get(i).show();
            System.out.println("----------------------------------------");
        }
    }
    
    public static void search(Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("\nNo contacts!");
            return;
        }
        
        System.out.print("\nEnter name to search: ");
        String name = sc.nextLine().toLowerCase();
        
        boolean found = false;
        for (Contact c : list) {
            if (c.name.toLowerCase().contains(name)) {
                System.out.println("\nFound:");
                c.show();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Not found!");
        }
    }
    
    public static void delete(Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("\nNo contacts!");
            return;
        }
        
        view();
        System.out.print("\nEnter number to delete: ");
        
        try {
            int idx = Integer.parseInt(sc.nextLine()) - 1;
            if (idx >= 0 && idx < list.size()) {
                list.remove(idx);
                System.out.println("Deleted!");
            } else {
                System.out.println("Invalid!");
            }
        } catch (Exception e) {
            System.out.println("Invalid!");
        }
    }
}
