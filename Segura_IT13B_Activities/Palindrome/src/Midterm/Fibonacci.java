
package Midterm;


public class Fibonacci {
    public static int f(int n){
        if (n <= 1){
            return n; 
              }else{ 
            return f(n-1)+ f(n-2);
        }
                }
    
    public static void main(String[] args){
        
        int n= 10;
        System.out.println("n = 10:");
        
        for (int i= 0; i < n; i++){
        System.out.print(f(i)+",");
    }
        
    }
}
