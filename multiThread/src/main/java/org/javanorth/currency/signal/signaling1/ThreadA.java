package org.javanorth.currency.signal.signaling1;

public class ThreadA extends Thread {
    private NorthPrint1 print;

    public ThreadA(NorthPrint1 print) {
        this.print = print;
    }

    @Override
    public void run() {
        print.printNumber();
    }
}
