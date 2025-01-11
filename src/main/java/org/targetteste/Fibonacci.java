package org.targetteste;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(isFibonacci(13));
        System.out.println(isFibonacci(50));
    }

    public static boolean isFibonacci(int number){
        return isSquare(5 * number * number + 4) ||
                isSquare(5 * number * number - 4);
    }

    public static boolean isSquare(int number){
        int square = (int)Math.sqrt(number);
        return number == square * square;
    }
}
