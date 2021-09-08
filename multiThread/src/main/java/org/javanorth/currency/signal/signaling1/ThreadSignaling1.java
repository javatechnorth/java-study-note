package org.javanorth.currency.signal.signaling1;

public class ThreadSignaling1 {

    public static void main(String[] args) {
        NorthPrint1 print = new NorthPrint1();
        ThreadA threadA = new ThreadA(print);
        ThreadB threadB = new ThreadB(print);
        threadA.start();
        threadB.start();
    }

}
