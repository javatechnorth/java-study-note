package com.north.algorithm;

import java.util.Stack;

/**
 * 所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。例如153是水仙花数，153是一个3位数，并且153 = 111 + 555 + 333
 * 输入描述:
 * 第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。[3,7]
 * 第二行输入一个正整数m，表示需要返回第m个水仙花数。
 * 输出描述:
 * 返回长度是n的第m个水仙花数。个数从0开始编号。
 * 若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。
 * 若输入不合法，返回-1。
 * 示例1
 * 输入
 * 3 0
 * 输出
 * 153
 * 说明
 * 153是第一个水仙花数
 * 示例2
 * 输入
 * 9
 * 1
 * 输出
 * -1
 * 说明
 * 9超出范围
 */
public class Daffodils {
    public static void main(String[] args) {
        System.out.println(isFollower(153));
        int i =1;
        System.out.println(i++ ==1);
        System.out.println(daffodilsNumber(3,4));

    }
    public static int daffodilsNumber(int n,int m){
        if (n>=3 && n<=7){
            int start = 1;
            for (int i = 1 ; i<n;i++){
                start *= 10;
            }
            int maxInt = start *10  -1;

            int times = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i= start; i< maxInt ;i++){
                if (isFollower(i)){
                    System.out.println(i);
                    stack.push(i);
                    if (times++ == m){
                        return i;
                    }
                }
            }
            if(times >0 && m+1 > times && (!stack.isEmpty())){
                return stack.peek() * m;
            }
            return -1;


        }else {
            return -1;
        }

    }

    public static boolean isFollower(int num){
        int length = String.valueOf(num).length();

        int tmp = num;
        int total = 0;
        while(tmp >0){
            int w = tmp %10;
            int total1 = 1;
            for (int i =1 ;i <=length ;i++){
                total1 *= w;
            }
            total += total1;
            tmp /= 10;
        }
        return total == num;
    }
}
