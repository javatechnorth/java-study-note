package org.javanorth.currency.lamadaTest;

public class MyFunctionDemo {

    public static void printString(String str , MyFunction<String> myF){
        myF.print(str);
    }
    public static void main(String[] args) {
        printString("I love " , (str) -> {System.out.println(str + "Java North");});
    }
}
