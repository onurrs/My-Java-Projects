/*
*   Author: Haci Onur Sogut
*   Date: 25.04.2023
*   Description: Finds the nTh value from fibonacci series
 */

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf(":  %-4d",fibonacci(i));
        }
    }

    static int fibonacci(int n){

        if(n==0)
            return 0;
        if(n==1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);

    }
}
