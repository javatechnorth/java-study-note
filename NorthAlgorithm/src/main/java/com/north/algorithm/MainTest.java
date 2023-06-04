package com.north.algorithm;

import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            String str = in.nextLine();
            String[] strArray =  str.split(" ");
            int length = 0;
            if (strArray.length > 1){
                length=strArray[strArray.length-1].length();
            }

            System.out.println(length);

            str.substring(8);
        }
    }

}
