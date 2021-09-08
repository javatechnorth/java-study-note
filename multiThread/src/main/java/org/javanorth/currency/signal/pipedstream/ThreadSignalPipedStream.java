package org.javanorth.currency.signal.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadSignalPipedStream {

    private final PipedInputStream inputStream1;
    private final PipedOutputStream outputStream1;
    private final PipedInputStream inputStream2;
    private final PipedOutputStream outputStream2;
    private final byte[] MSG;

    public ThreadSignalPipedStream() {
        inputStream1 = new PipedInputStream();
        outputStream1 = new PipedOutputStream();
        inputStream2 = new PipedInputStream();
        outputStream2 = new PipedOutputStream();
        MSG = "Go".getBytes();
        try {
            inputStream1.connect(outputStream2);
            inputStream2.connect(outputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadSignalPipedStream signal = new ThreadSignalPipedStream();
        signal.threadA().start();
        signal.threadB().start();

    }

    public Thread threadA (){
        final String[] inputArr = new String[2];

        return new Thread() {
            String[] arr = inputArr;
            PipedInputStream in1 = inputStream1;
            PipedOutputStream out1 = outputStream1;
            @Override
            public void run() {
                int i = 1;
                while (i <= 26) {
                    try {
                        System.out.print(i * 2 - 1);
                        System.out.print(i * 2);
                        out1.write(MSG);
                        byte[] inArr = new byte[2];
                        in1.read(inArr);
                        while(!"Go".equals(new String(inArr))){ }
                        i++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public Thread threadB (){
        final String[] inputArr = new String[2];
        return new Thread() {
            private String[] arr = inputArr;
            private PipedInputStream in2 = inputStream2;
            private PipedOutputStream out2 = outputStream2;
            @Override
            public void run() {
                char i = 'A';
                while (i <= 'Z'){
                    try {
                        byte[] inArr = new byte[2];
                        in2.read(inArr);
                        while(!"Go".equals(new String(inArr))){  }
                        System.out.print(i);
                        i++;
                        out2.write(MSG);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
