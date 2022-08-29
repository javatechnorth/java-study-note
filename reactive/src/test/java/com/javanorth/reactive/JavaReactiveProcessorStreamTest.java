package com.javanorth.reactive;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class JavaReactiveProcessorStreamTest {

    @Test
    public void reactiveProcessorJavaTest()  {

        SubmissionPublisher publisher = new SubmissionPublisher<>();

        ReactiveProcessor reactiveProcessor = new ReactiveProcessor();

        publisher.subscribe(reactiveProcessor);


        Flow.Subscriber subscriber = new Flow.Subscriber() {
            Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println(Thread.currentThread().getName() +  " Subscription first establish ");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Object item) {
                subscription.request(10);
                System.out.println(Thread.currentThread().getName() +"  receive :  "+ item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(" onError ");
            }

            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getName() + " onComplete ");
            }
        };


        reactiveProcessor.subscribe(subscriber);

        for (int i = 0; i < 10; i++) {
            publisher.submit("test reactive java : " +i);
        }

        publisher.close();
        try {
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
