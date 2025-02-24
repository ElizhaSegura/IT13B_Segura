package Prelim;

import java.util.Scanner;



public class Lab_Exercise2_GreatestNumber {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter 1st Number: ");
        int firstNum = in.nextInt();
        System.out.println("Enter 2nd Number: ");
        int secNum = in.nextInt();
        System.out.println("Enter 3rd Number: ");
        int thirdNum = in.nextInt();

        int greatestNum = firstNum;

        if (secNum > greatestNum) {
            greatestNum = secNum;
        }
        if (thirdNum > greatestNum) {
            greatestNum = thirdNum;
        }
        System.out.println("The greatest number is " + greatestNum);

    }

}
