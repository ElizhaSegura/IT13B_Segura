package Midterm;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling_Encryption {

    public static void main(String[] args) {
             int key = 6;
        String message = "I love you!\nGwapa ko!\nBuotan si Ma'am";
            String encryptedMessage = encryptMessage(message, key);

        try (FileWriter myWriter = new FileWriter("C:\\Users\\elizh\\OneDrive\\Documents\\FileHandling_Encryption.txt")) {
            myWriter.write(encryptedMessage);
                System.out.println("Encrypted message: ");
                     System.out.println(encryptedMessage);
        } catch (IOException e) {
                   }
    }

    public static String encryptMessage(String message, int key) {
            char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
             if (chars[i] != '\n') {
                chars[i] += key;
            }
        }
        return new String(chars);
    }
}
