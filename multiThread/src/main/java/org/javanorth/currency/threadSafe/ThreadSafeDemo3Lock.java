package org.javanorth.currency.threadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDemo3Lock {
    public static void main(String[] args) throws InterruptedException {
        TicketLockStation station = new TicketLockStation();
        new Thread(station,"软软").start();
        new Thread(station,"冰冰").start();
        new Thread(station,"指北君").start();
    }
}

class TicketLockStation implements Runnable{

    private Lock lock = new ReentrantLock();

    int ticketCount = 10;
    boolean hasTicket = true;
    @Override
    public void run() {
        while(hasTicket){buyTicket();}
    }
    private void  buyTicket(){
        lock.lock();
        try {
        if (ticketCount < 1) {
            hasTicket = false;
            return;
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " get the ticket"+ ticketCount--);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
