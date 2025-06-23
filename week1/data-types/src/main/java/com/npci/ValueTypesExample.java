package com.npci;

public class ValueTypesExample {
    public static void main(String[] args) {

        byte byteValue = 127; // 8 bits -> -128 to 127
        short shortValue = 32767; // 16 bits -> -32,768 to 32,767
        int intValue = 2147483647; // 32 bits -> -2,147,483,648 to 2,147,483,647
        long longValue = 9223372036854775807L; // 64 bits -> -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

        float floatValue = 3.4028235E38F; // 32 bits -> approximately -3.4028235E38 to 3.4028235E38
        double doubleValue = 1.7976931348623157E308; // 64 bits -> approximately -1.7976931348623157E308 to 1.7976931348623157E308

        char charValue = 'A'; // 16 bits -> Unicode character (0 to 65,535)
        char unicodeChar = '\u0041'; // Unicode representation of 'A'

        boolean booleanValueTrue = true; // Represents true or false

        //--------------------------

        long my_salary = 100_0000_0000L;
        System.out.println(my_salary);

        //---------------------------

        int decimal=12; // Decimal representation
        int octal=012; // Octal representation (base 8)
        int hexadecimal=0x12; // Hexadecimal representation (base 16)
        int binary=0b1100; // Binary representation (base 2)

        //---------------------------

        int a=6;
        int b=4;
        float c=a/b;
        System.out.println(c);

        // type casting
        // implicit casting ( JRE will do it automatically )
        // explicit casting ( you have to do it manually )

        //----------------------------

        int n=456;
        byte b1 = (byte) n;
        System.out.println(b1);


        //----------------------------


        /**
         *  Account
         *  *  int accountNumber;
         *  *  double accountBalance;
         */



    }
}
