/**
 * Student: Dan Albert Solis
 * Date: 2/5/2021
 * Program description: This program converts user provided binary or decimal to octal or hexadecimal.
 */

import java.util.Scanner;

class Lab1 {
    public Lab1(){}

    /**
     * Converts binary to decimal, loops across all places of integer and if there exists a 1 in a place, it will add 2
     * to the n power (n being the amount of number places)
     * @param a
     * @return
     */
    int binarytoDecimal(int a){
        int decimal = 0;
        int posCount = 1;

        String str = String.valueOf(a);

        for (int i = str.length() - 1; i >= 0; i--){
            if (str.charAt(i) == '1'){
                decimal += (posCount);
            }
            posCount *= 2;
        }
        return decimal;
    }

    /**
     * Converts decimal to binary by division-remained method. Builds the binary string in "reverse order", casted into
     * string builder to reverse.
     * @param a
     */
    void decimalToBinary(int a){
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
        System.out.println("Binary:" + sBuild);


    }

    /**
     * Converts decimal to hexadecimal, uses char array to provide hex dictionary. Loops int a until 0 is reached.
     * @param a
     */
    void decimalToHexa(int a){
        String Hexa ="";
        int temp = 0;
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (a != 0){
            temp = a % 16;
            Hexa +=  hex[temp];//String.valueOf(temp);
            a/= 16;
        }




        StringBuilder sBuild = new StringBuilder();
        sBuild.append(Hexa);
        sBuild.reverse();
        System.out.println("Hexadecimal:" + sBuild);


    }

    /**
     * Converts decimal to octal.
     * @param a
     */
    void decimalToOctal(int a){
        String Octal ="";
        int temp = 0;

        while (a != 0){
            temp = a % 8;
            Octal +=  String.valueOf(temp);
            a/= 8;
        }



        StringBuilder sBuild = new StringBuilder();
        sBuild.append(Octal);
        sBuild.reverse();
        System.out.println("Octal:" + sBuild);
    }

}

class Driver{
    public static void main(String[] args){
        Lab1 l1 = new Lab1();
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter in a binary or decimal number: ");
        int intput = stdin.nextInt();
        System.out.print("Is this a binary or decimal? Type 0 for binary, or anything else for decimal: ");
        int binaryOrDecimal = stdin.nextInt();

        if (binaryOrDecimal == 0){
            System.out.println("Decimal: "+l1.binarytoDecimal(intput));
            l1.decimalToHexa(l1.binarytoDecimal(intput));
            l1.decimalToOctal(l1.binarytoDecimal(intput));
        }
        else{
            l1.decimalToBinary(intput);
            l1.decimalToHexa(intput);
            l1.decimalToOctal(intput);

        }


        //l1.binarytoDecimal(10110);
        //stdin
    }
}
