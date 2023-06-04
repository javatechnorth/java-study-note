package com.north.odTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

//        3
//        2 3 1
//        6 9 2
//        0 5 1
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int taskNum = 3;
        List<TaskSource> taskSourceList = new ArrayList<>();
        String[] strings = {"2 3 1","6 9 2","0 5 1"};
        for (int i=0 ; i<taskNum ;i++ ){
            String input = strings[i];
            String[] split = input.split(" ");
            taskSourceList.add(new TaskSource(Integer.valueOf(split[0]),Integer.valueOf(split[1]), Integer.valueOf(split[2])));
        }
        int total = 0;
        for (TaskSource source : taskSourceList){
            for (TaskSource source1 : taskSourceList){
                if(source.startTime < source1.startTime && source.endTime<=source1.endTime){
//                    total +=
                }
            }

        }
        System.out.print(total);

//        taskSourceList


    }

    static class TaskSource{
        int startTime;
        int endTime;
        int parallelism;
        TaskSource(){
        }
        TaskSource(int startTime , int endTime,int parallelism){
            this.startTime = startTime;
            this.endTime = endTime;
            this.parallelism = parallelism;
        }
    }
}
