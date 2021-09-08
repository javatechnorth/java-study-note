package org.javanorth.currency.signal.volatilesignal;

public class ThreadSignalingVolatile {

    enum ThreadRunFlag{PRINT_NUM, PRINT_CHAR}
    private volatile static ThreadRunFlag threadRunFlag = ThreadRunFlag.PRINT_NUM;

    public static void main(String[] args) {

        new Thread(() -> {
            int i = 1;
            while (i <= 26) {
                while(threadRunFlag == ThreadRunFlag.PRINT_CHAR){}
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                i++;
                threadRunFlag = ThreadRunFlag.PRINT_CHAR;
            }
        }).start();

        new Thread(()->{
            char i = 'A';
            while (i <= 'Z'){
                while (threadRunFlag == ThreadRunFlag.PRINT_NUM){}
                System.out.print(i);
                i++;
                threadRunFlag = ThreadRunFlag.PRINT_NUM;
            }
        }).start();

    }
}