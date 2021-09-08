package org.javanorth.currency.signal.signaling1;

public class NorthPrint1 {
    protected boolean printChar = false;
    public synchronized void printNumber() {
        try {
            for (int i = 1; i <= 26; ) {
                if (printChar) {
                    wait();
                }else {
                    System.out.print(i * 2 - 1);
                    System.out.print(i * 2);
                    printChar=true;
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
                if (!printChar) {
                    wait();
                }else {
                    System.out.print((char)i);
                    printChar=false;
                    i++;
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}