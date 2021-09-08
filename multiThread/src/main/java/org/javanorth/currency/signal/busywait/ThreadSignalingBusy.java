package org.javanorth.currency.signal.busywait;

public class ThreadSignalingBusy {

    public static void main(String[] args) {
        NorthSignal signal = new NorthSignal();
        ThreadA threadA = new ThreadA(signal);
        ThreadB threadB = new ThreadB(signal);
        threadA.start();
        threadB.start();

    }



    public static class ThreadA extends Thread {
        private NorthSignal sharedSignal;

        public ThreadA(NorthSignal sharedSignal) {
            this.sharedSignal = sharedSignal;
        }

        @Override
        public void run() {
            int i = 1;
            while(i <= 26) {
                if(!this.sharedSignal.hasDataToProcess()) {
                    System.out.print(i * 2 - 1);
                    System.out.print(i * 2);
                    this.sharedSignal.setHasDataToProcess(true);
                    i++;
                }
            }

        }
    }

    public static class ThreadB extends Thread {
        private NorthSignal sharedSignal;

        public ThreadB(NorthSignal sharedSignal) {
            this.sharedSignal = sharedSignal;
        }

        @Override
        public void run() {
            char i = 'A';
            while(i <= 'Z') {
                if(this.sharedSignal.hasDataToProcess()){
                    System.out.print(i);
                    this.sharedSignal.setHasDataToProcess(false);
                    i++;
                }
            }
        }

        }
}


