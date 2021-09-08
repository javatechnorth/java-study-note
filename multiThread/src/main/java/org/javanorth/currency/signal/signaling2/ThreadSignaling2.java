package org.javanorth.currency.signal.signaling2;

public class ThreadSignaling2 {

    public static void main(String[] args) {
        NorthPrint print = new NorthPrint(new NorthSignal());
        ThreadA threadA = new ThreadA(print);
        ThreadB threadB = new ThreadB(print);
        threadA.start();
        threadB.start();

    }
public static class ThreadA extends Thread {
    private NorthPrint print;
    public ThreadA(NorthPrint print) {
        this.print = print;
    }
    @Override
    public void run() {
        print.printNumber();

    }
}

public static class ThreadB extends Thread {
    private NorthPrint print;
    public ThreadB(NorthPrint print) {
        this.print = print;
    }
    @Override
    public void run() {
        print.printChar();
    }
}
}