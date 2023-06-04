package com.north.odTest;

import java.util.*;

public class MVP {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        in.nextInt();
//        9
//        5 2 1 5 2 1 5 2 1
        int t = 9;
        String p = "5 2 1 5 2 1 5 2 1";
        String[] split = p.split(" ");
        List<Integer> scList = new ArrayList<>();
        int total = 0;

        for (int i = 0 ; i< split.length ;i++){
            scList.add(Integer.valueOf(split[i]));
            total += Integer.valueOf(split[i]);
        }
//        System.out.println(total);

        for(int i = 5 ; i >0 ;i--){
            if (total%i == 0){
                System.out.println(total/i);
                break;
            }
        }
//        for(int i = 5 ; i >0 ;i--){
//            Collections.sort(scList,((o1, o2) -> o2-o1));
//            if (total%i == 0 && scList.get(0)<= total/i){
//                int avScore = total/i;
//                Queue<Integer> queue = new LinkedList<>();
//                Stack<Integer> stack = new Stack<>();
//                int tmp = 0;
//                List<Integer> tmpList = new ArrayList<>();
//                Collections.copy(tmpList,scList);
//                for(int j =0 ;j< scList.size() ;j++){
//                    if(scList.get(j) == avScore){
//                        tmpList.remove(scList.get(j));
//                    }else if(tmp + scList.get(j) == avScore){
//
//                            tmpList.remove(scList.get(j));
//                            tmpList.remove(tmp);
//                            tmp = 0;
//                    }else if (tmp + scList.get(j) < avScore){
//                        tmp += scList.get(j);
//                    }
//
//                }
//
//                if(!queue.isEmpty()){
//
//                }
//            }
//        }


    }
}
