/*
*   Author: Haci Onur Sogut
*   Date: 25.04.2023
*   Description: Addition of harmonic series +(1/n)
 */

public class HarmonicSeries {

    static double sum = 0;  //adding every value together, also known as Partial Sum

    public static void main(String[] args) {
        System.out.print("Step  Fraction \t\tSum\n");
        for (double i = 1; i<=100; i++){
            sum+=1/i;
            System.out.printf("%3d:  (%d/%d) \t+>\t%.5f\n", (int)i, 1, (int) i, sum);
        }
    }
}
