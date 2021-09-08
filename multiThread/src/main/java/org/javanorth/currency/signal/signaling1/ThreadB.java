package org.javanorth.currency.signal.signaling1;

public class ThreadB  extends Thread {
    private NorthPrint1 print;
    public ThreadB(NorthPrint1 print) {
        this.print = print;
    }
    @Override
    public void run() {
        print.printChar();
    }
}
