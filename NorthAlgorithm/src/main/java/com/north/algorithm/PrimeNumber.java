package com.north.algorithm;


/**
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
 * 输入描述:
 * 一个正整数num
 * 0 < num <= 2147483647
 * 输出描述:
 * 如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1
 * 示例1
 * 输入
 * 15
 * 输出
 * 3 5
 * 说明
 * 因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5
 * 示例2
 * 输入
 * 27
 * 输出
 * -1 -1
 * 说明
 * 通过因数分解，找不到任何素数，使得他们的乘积为27，输出-1 -1
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(primeMulti(15));
        System.out.println(primeMulti(27));
        System.out.println(primeMulti(4757));
    }

    public static String primeMulti(int num){
        int max = num;
        for (int i = 2 ; i<= max ;i++){
            if(num%i == 0){
                max = num/i;
                if(isPrime(i) && isPrime(num/i)){
                    return i+" "+num/i;
                }
            }
        }
        return  "-1"+" "+"-1";
    }

    public static boolean isPrime(int number){
        if(number == 1){
            return false;
        }else {
            for(int i =2 ;i<Math.sqrt(number)+1;i++){
                if (number%i ==0){
                    return false;
                }
                if(i > Math.sqrt(number) ){
                    return true;
                }
            }
            return true;

        }
    }
}
