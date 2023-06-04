package com.north.odTest;


import java.util.*;

public class Record {

//    2
//   100000,10,1,ABCD,ABCD
//100000,80,10,ABCE,ABCD
    public static void main(String[] args) {
        int records = 2 ;
        String line1 = "100000,10,1,ABCD,ABCD";
        String line2 = "100000,80,10,ABCE,ABCD";

        Scanner in = new Scanner(System.in);
////        int records = in.nextInt();
//        while(in.hasNext()){
//
//        }

        Queue<Integer> times = new LinkedList<>();
        Queue<Integer> distances = new LinkedList<>();
        String firstRecord = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i< records;i++ ){
            String input  = in.next();
            if(i ==0 ){
                firstRecord = input;
            }
            String[] split = input.split(",");
            int time  = Integer.valueOf(split[1]);
            times.add(time);
            int distance = Integer.valueOf(split[2]);
            distances.add(distance);
            String actualDeviceID = split[3];
            String registDeviceID = split[4];
            if (!actualDeviceID.equals(registDeviceID) || !validTimeAndDistance(times,distances) ){
                if(i == 1){
                    builder.append(firstRecord+";");
                }
                builder.append(input+";");
            }
        }
        String string = builder.toString();
        if(string.equals("")){
            System.out.print("null");
        }else{
            System.out.print(string.substring(0,string.lastIndexOf(";")-1));
        }
    }

    private static boolean validTimeAndDistance(Queue<Integer> times, Queue<Integer> distances) {
        if (times.size() >1 && distances.size()>1) {
            Integer lastTime = times.poll();
            Integer currentTime = times.peek();

            Integer lastDistance = distances.poll();
            Integer currentDistance = distances.peek();
            return currentTime - lastTime > 60 && currentDistance- lastDistance <5;
        }
        return true;
    }
}
