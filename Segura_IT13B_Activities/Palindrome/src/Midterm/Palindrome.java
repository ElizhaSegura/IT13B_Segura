package Midterm;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        
        String txt, rev = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word: ");
        txt = in.nextLine();

        txt = txt.toUpperCase();

        System.out.println();

        int length = txt.length();

        for (int i = length - 1; i >= 0; i--) {
            rev = rev + txt.charAt(i);
        }

        if (txt.equals(rev)) {
            System.out.println(txt + " is a palindrome.");
        } else {
            System.out.println(txt + " is NOT a palindrome.");
        }
    }
}
