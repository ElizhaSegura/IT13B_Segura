package Midterm;

public class Array {

    public static void main(String[] args) {

        //1. Single Array
        char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int x = 0; x <= letters.length - 1; x++) {
            System.out.print(letters[x] + ",");
        }
        System.out.println();

        //2. Multi-dimensional
        int numbers[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        for (int x = 0; x < numbers.length; x++) {
            System.out.print("The Elements in Row " + (x + 1) + ": ");
            for (int y = 0; y < numbers[x].length; y++) {
                System.out.print(numbers[x][y] + " ");
            }
            System.out.println();
        }

    }
}
