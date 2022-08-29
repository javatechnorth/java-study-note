package com.javanorth.reactive;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class JavaReactiveStreamTest {

    @Test
    public void reactiveJavaTest1()  {

        SubmissionPublisher publisher = new SubmissionPublisher<>();
        Flow.Subscriber subscriber = new Flow.Subscriber() {
            Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("Subscription establish first ");
                this.subscription = subscription;
                this.subscription.request(1);
            }
            @Override
            public void onNext(Object item) {
                subscription.request(10);
                System.out.println("receive :  "+ item);
            }
            @Override
            public void onError(Throwable throwable) {
                System.out.println(" onError ");
            }
            @Override
            public void onComplete() {
                System.out.println(" onComplete ");
            }
        };
        publisher.subscribe(subscriber);
        for (int i = 0; i < 20; i++) {
            publisher.submit("test reactive java : " +i);
        }

        try {
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
