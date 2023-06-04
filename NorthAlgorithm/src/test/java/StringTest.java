import org.junit.Test;

import java.util.*;

public class StringTest {

    @Test
    public void test1(){

        // 注意 hasNext 和 hasNextLine 的区别
    // 注意 while 处理多个 case
//            String str = "0xAA";
//            System.out.println(Integer.parseInt(str.substring(2,str.length()),16));

        long a = 645777;

        long k = (long)Math.sqrt(a);
        for (int i = 2; i <= k; i++) {
            while (a % i == 0) {
                System.out.print(i + " ");
                a /= i;
            }
        }
        System.out.print(a==1? "":a);

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        TreeMap<Integer,Integer> map = new TreeMap<>();
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int n = in.nextInt();
//            for(int i = 0;i<n ;++i){
//                int k = in.nextInt();
//                int v = in.nextInt();
//                map.put(k,map.getOrDefault(k,0)+v);
//            }
//        }
//        map.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() +" " + entry.getValue());
//        });


//        TreeSet<Integer> numbers = new TreeSet<>(Comparator.naturalOrder());
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String a = in.nextLine();
//            String[] split = a.split("");
//            for(int i = 0; i < split.length ;i++){
//                numbers.add(Integer.valueOf(split[i]));
//            }
//
////            numbers.add(a);
////            numbers.to
//            LinkedList <Integer> list = new LinkedList<>(numbers);
////            list.
//            list.getLast();
//            list.removeLast()
//            list.forEach(aa ->{
//                    System.out.print(aa);
//            });
////            numbers.
//            Iterator<Integer> iterator = numbers.iterator();
//        Stack<Character> stack = new Stack<>();
////        stack.
//        Queue<Character> queue = new ArrayDeque<>();
//        queue.offer('1');
//
//        }
        int i = 10;
//        Integer.toString()
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toString(16,2));
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(63));
        System.out.println(Integer.toBinaryString(64));
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(128));

        System.out.println(255 +"="+ Integer.toBinaryString(255));
        System.out.println(Integer.toBinaryString(256));
        System.out.println(255 +"&256:"+ (255 & 256));
        System.out.println(255 +"&255:"+ (255 & 255));
        System.out.println(32 +"&255:"+ (32 & 255));
        System.out.println(32 +"&256:"+ (32 & 256));
        System.out.println(31 +"&255:"+ (31 & 255));
        System.out.println(31 +"&256:"+ (31 & 256));
        System.out.println(30 +"&256:"+ (30 & 256));
        System.out.println(255 +"^255:"+ (255 ^ 255));
        System.out.println(32 +"^255:"+ (32 ^ 255));
        System.out.println(31 +"^255:"+ (31 ^ 255));
        System.out.println(31 +"|255:"+ (31 |255));
        System.out.println(32 +"|255:"+ (32 |255));
        System.out.println(31 +"& 0:"+ (31 & 0));
        System.out.println(31 +"& 1:"+ (31 & 1));
        System.out.println(31 +"& 2:"+ (31 & 2));
//        System.out.println(255 +"="+ Integer.toBinaryString(255));
//        System.out.println(256 +"="+ Integer.toBinaryString(256));
//        System.out.println(32 +"="+ Integer.toBinaryString(32));
//        System.out.println(31 +"="+ Integer.toBinaryString(31));
//        System.out.println(30 +"="+ Integer.toBinaryString(30));
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(Integer.toBinaryString(i & 1));
//        System.out.println(5 & 1);
//        System.out.println(4 & 1);
//        System.out.println(3 & 1);
//
//        System.out.println(15 & 5);
//        System.out.println(15 & 4);
//        System.out.println(15 & 3);
//        System.out.println(15 & 18);
//
//        System.out.println(31 & 18);
//        System.out.println(31 & 4);
//        System.out.println(31 & 3);

//        System.out.println(Integer.toBinaryString(i~;));
//        System.out.println(Integer.toBinaryString(i^));


//        for(int i = 0 ; i < numbers.size();i++){
//            System.out.print(numbers.pollFirst());
//        }
        String [] ipAndMask = {"172.16..0","255.254.255.0"};

        System.out.println(ipAndMask[0].split("\\.").length);
        System.out.println(ipAndMask[0].split("\\.")[2]);
//
        String [] ipAndMask1 = {"19..0.","255.255.255.32"};
//        System.out.println(inValidIP(ipAndMask1));
        System.out.println(wrongIPOrMask(ipAndMask1));
//        System.out.println(Integer.valueOf(""));
//        System.out.println("19..0.".split("\\.").length);
        System.out.println("1111111".indexOf("0"));
        System.out.println("00000".indexOf("1"));
        System.out.println(isPersonalIP("192.168.0.2"));
    }
    public static boolean wrongIPOrMask(String [] ipAndMask){
        System.out.println("ipAndMask : " + ipAndMask[1]);
        String[] mask = ipAndMask[1].split("\\.");
        String binaryMask = "";
        System.out.println("mask : " + mask);
        for(String str : mask){
            System.out.println("mask : " + str + "==="+("00000000"+Integer.toBinaryString(Integer.valueOf(str))));
            System.out.println("mask1 : " + str + "==="+("00000000"+Integer.toBinaryString(Integer.valueOf(str))).substring(("00000000"+Integer.toBinaryString(Integer.valueOf(str))).length()-8));
            System.out.println("str : " + (Integer.toBinaryString(Integer.valueOf(str))+"00000000").substring(0,8));
            binaryMask += (Integer.toBinaryString(Integer.valueOf(str))+"00000000").substring(0,8);
        }
        System.out.println("binaryMask : " + binaryMask);
        System.out.println("lastIndexOf : " + binaryMask.lastIndexOf("1"));
        System.out.println("indexOf : " + binaryMask.indexOf("0"));
        return binaryMask.lastIndexOf("1") > binaryMask.indexOf("0");
    }
    public static boolean inValidIP(String [] ipAndMask){
        String[] ip = ipAndMask[0].split("\\.");
        if(ip.length!=4) return true;

        for (String str :ip){
            if(str.equals("")){
                return true;
            }
        }
        return false;

    }

    public static boolean isPersonalIP(String ip){
        return (Integer.valueOf(ip.split("\\.")[0]) == 10)
                || (Integer.valueOf(ip.split("\\.")[0])==172
                && (Integer.valueOf(ip.split("\\.")[1])>15
                && Integer.valueOf(ip.split("\\.")[1])<32))

                || (Integer.valueOf(ip.split("\\.")[0])==192 && Integer.valueOf(ip.split("\\.")[1])==168)
                ;
    }

}
