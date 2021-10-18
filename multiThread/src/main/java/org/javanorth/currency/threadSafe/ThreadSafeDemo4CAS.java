package org.javanorth.currency.threadSafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDemo4CAS {
    public static void main(String[] args) throws InterruptedException {
        TicketCASStation station = new TicketCASStation();
        new Thread(station,"软软").start();
        new Thread(station,"冰冰").start();
        new Thread(station,"指北君").start();
    }
}

class TicketCASStation implements Runnable{

    AtomicInteger ticketSalesControl = new AtomicInteger(10);
//    int ticketCount = 10;
    boolean hasTicket = true;
    @Override
    public void run() {
        while(hasTicket){buyTicket();}
    }
    private void  buyTicket(){

        if(ticketSalesControl.decrementAndGet() < 1) {
            hasTicket = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " get the ticket"+ ticketSalesControl.get());

//        ticketSalesControl.compareAndSet();
//        while (ticketSalesControl.get() == 0){};
//        ticketSalesControl.compareAndSet(1,0);
//        if (ticketCount < 1) {
//            hasTicket = false;
//            ticketSalesControl.compareAndSet(0,1);
//            return;
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + " get the ticket"+ ticketCount--);
//        ticketSalesControl.compareAndSet(0,1);



    }
}
