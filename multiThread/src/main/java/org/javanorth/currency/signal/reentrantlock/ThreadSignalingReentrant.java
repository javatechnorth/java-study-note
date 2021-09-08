package org.javanorth.currency.signal.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSignalingReentrant {
    public static void main(String[] args) {
        ThreadToGo threadToGo = new ThreadToGo();
        Lock lock = new ReentrantLock();
        Condition print_number = lock.newCondition();
        Condition print_char = lock.newCondition();

        new Thread(() -> {
            try{

                lock.lock();
                int i = 1;
                while (i <= 26) {
                    while(threadToGo.getThreadToGo() == 1){
                        print_char.await();
                    }
                    System.out.print(i * 2 - 1);
                    System.out.print(i * 2);
                    i++;
                    threadToGo.setThreadToGo(2);
                    print_char.signal();
                    print_number.await();
                }
                print_char.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try{
                lock.lock();
                char i = 'A';
                while (i <= 'Z') {
                    while(threadToGo.getThreadToGo() == 2){
                        print_number.await();
                    }
                    System.out.print(i);
                    i++;
                    print_number.signal();
                    print_char.await();
                }
                print_number.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
    }
}


