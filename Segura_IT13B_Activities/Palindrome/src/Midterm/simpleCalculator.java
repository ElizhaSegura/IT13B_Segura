package Midterm;

import java.util.Scanner;

public class simpleCalculator {
    
    public static double add(double a, double b) {
        return a + b;
         }
    public static double subtract(double a, double b){
        return a - b;
    }
    public static double multiply(double a, double b){
        return a * b;
    }
    public static double divide(double a, double b){
       if (b ==0){
           System.out.print("Error");
           return Double.NaN;
       }
        return a / b;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = in.nextDouble();
                
        System.out.print("Enter operator (+,-,*,/): ");
        char operator = in.next().charAt(0);
        
        System.out.print("Enter second number: ");
        double num2 = in.nextDouble();
        
        double result;
        switch (operator){
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result= divide(num1, num2);
                break;
            default: 
                System.out.println("Error");
                return;
        }
        System.out.println("Result: "+ result);
        in.close();
    }
}
    

    