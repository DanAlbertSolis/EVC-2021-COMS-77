/**
 * Student: Dan Albert Solis
 * Date: 2/12/2021
 * Program description: This program converts user provided int floating point to simple model of floating point
 * representation.
 */
import java.util.Scanner;

public class Lab2 {
    public Lab2(){ }


    /**
     * Converts decimal to binary by division-remained method. Builds the binary string in "reverse order", casted into
     * string builder to reverse.
     * @param a
     */
    String decimalToBinary(int a){
        String binary ="";
        int temp = 0;

        while (a != 0){
            temp = a % 2;
            binary +=  String.valueOf(temp);
            a/= 2;
        }



        StringBuilder sBuild = new StringBuilder();
        sBuild.append(binary);
        sBuild.reverse();
        binary = sBuild.toString();

        return binary;

    }


}

class Driver{
    public static void main(String[] args){
        Lab2 l2 = new Lab2();
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the floating point number: "); // limited to int floating point as algorithm only uses int
        int a = stdin.nextInt();

        /**
         * If a is negative, decimal to Binary algorithm causes incorrect output of '-' between numbers.
         * This workaround mitigates issue.
         */
        int b = a;
        if (b < 0){
            b = b * -1;
        }
        String temp = l2.decimalToBinary(b);
        while (temp.length() != 8){
            temp+=0;
        }
        System.out.println("8 bit Significand/Mantissa:" + temp);

        int eNum = temp.length() - 1; //eNum = to length of number
        String temp2 = l2.decimalToBinary(eNum + 15); // bias 15
        System.out.println("5 bit exponent: " + temp2);

        int sign;

        if (a > 0){ // Decides whether the sign bit is positive or negative and assigns according bit value
            sign = 0;
        }
        else{
            sign = 1;
        }
        System.out.println("1 bit sign: " + sign);

        System.out.printf("Sign | 5 Bit Exponent | 8 bit Mantissa\n");
        System.out.printf("%5d|%16s|%15s\n", sign, temp2, temp);







    }
}

