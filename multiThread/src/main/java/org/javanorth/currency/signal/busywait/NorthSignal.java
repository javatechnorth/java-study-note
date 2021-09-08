package org.javanorth.currency.signal.busywait;

public class NorthSignal {
    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData){
        this.hasDataToProcess = hasData;
    }
}
