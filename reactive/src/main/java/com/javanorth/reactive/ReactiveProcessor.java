package com.javanorth.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveProcessor extends SubmissionPublisher implements Flow.Subscriber {
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println( Thread.currentThread().getName() +  " Reactive processor establish connection ");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        System.out.println(Thread.currentThread().getName() + " Reactive processor receive data: "+ item);
        this.submit(item.toString().toUpperCase());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Reactive processor error ");
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println(Thread.currentThread().getName() + " Reactive processor receive data complete ");
    }
}
