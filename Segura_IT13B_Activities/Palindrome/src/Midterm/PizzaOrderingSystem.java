
package Midterm;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PizzaOrderingSystem {
    static final String fileName = "C:\\Users\\elizh\\OneDrive\\Documents\\users.txt"; 
    static final int shiftKey = 3;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int[] prices = {380,250, 350};
        int[] quantities = new int[3];
        String[] items = {"Italian", "Ham & Cheese", "Beef & Mushrooms"};

        System.out.println("🍽️️ Welcome to the Pizza Ordering System!");
        System.out.println("[1] Login\n[2] Create Account\n[3] Checkout");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 3) {
            System.out.println("Thank you for visiting. Goodbye!");
            return;
        }

       try {
            if (choice == 2) {
                System.out.println("\n🧾 Create New Account");
                System.out.print("Enter new username: ");
                String newUser = sc.nextLine();
                System.out.print("Enter new password: ");
                String newPass = encrypt(sc.nextLine());

                try (FileWriter fw = new FileWriter(fileName, true)) {
                    fw.write(newUser + "," + newPass + "\n");
                }
                System.out.println("✔️ Account created successfully!\n");
            }

            System.out.println("\n🔐 Login");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = encrypt(sc.nextLine());

            if (login(username, password)) {
                System.out.println("✔️ Login successful!\n");

                int item;
                do {
                    System.out.println("\n🚗 --- Menu ---");
                    for (int i = 0; i < items.length; i++) {
                        System.out.println((i + 1) + ". " + items[i] + " - ₱" + prices[i]);
                    }
                    System.out.println("4. Checkout");
                    System.out.print("Choose a pizza: ");
                    item = sc.nextInt();

                    if (item >= 1 && item <= 3) {
                        System.out.print("Enter quantity: ");
                        quantities[item - 1] += sc.nextInt();
                    } else if (item != 4) {
                        System.out.println("❗ Invalid option.");
                    }
                } while (item != 4);

                System.out.println("\n📦 --- Your Receipt ---");
                int total = 0;
                for (int i = 0; i < 3; i++) {
                    if (quantities[i] > 0) {
                        int cost = quantities[i] * prices[i];
                        System.out.println(items[i] + " x" + quantities[i] + " = ₱" + cost);
                        total += cost;
                    }
                }
                System.out.println("💰 Total: ₱" + total);
            } else {
                System.out.println("❌ Invalid credentials.");
               
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error handling file: " + e.getMessage());
        }
    }

    public static boolean login(String username, String password) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) return false;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char) (c + shiftKey));
        }
        return encrypted.toString();
    }

}
