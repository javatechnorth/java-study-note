package org.javanorth.currency.threadSafe;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeDemo3 {
    public static void main(String[] args) throws InterruptedException {
        TicketStation station = new TicketStation();
        new Thread(station,"软软").start();
        new Thread(station,"冰冰").start();
        new Thread(station,"指北君").start();
    }
}
class TicketStation implements Runnable{
    int ticketCount = 10;
    boolean hasTicket = true;
    @Override
    public void run() {
        while(hasTicket){buyTicket();}
    }
    private synchronized  void  buyTicket(){
        if (ticketCount < 1) {
            hasTicket = false;
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " get the ticket"+ ticketCount--);
    }
}
