package org.javanorth.currency.signal.signaling2;

public class NorthPrint {
    private NorthSignal signal;
    public NorthPrint(NorthSignal signal) {
        this.signal = signal;
    }

    public synchronized void printNumber() {
        try {
            for (int i = 1; i <= 26; ) {
                if (signal.hasDataToProcess()) {
                    wait();
                }else {
                    System.out.print(i * 2 - 1);
                    System.out.print(i * 2);
                    signal.setHasDataToProcess(true);
                    i++;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printChar() {
        try {
            for (int i = 'A'; i <= 'Z'; ) {
                if (!signal.hasDataToProcess()) {
                    wait();
                }else {
                    System.out.print((char)i);
                    signal.setHasDataToProcess(false);
                    i++;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}