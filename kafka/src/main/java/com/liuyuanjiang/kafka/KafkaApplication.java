package com.liuyuanjiang.kafka;

import com.liuyuanjiang.kafka.source.KafkaSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBinding(KafkaSource.class)
public class KafkaApplication {



	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

//	@StreamListener(Sink.INPUT)
//	public void receive(Message<String> message) {
//		String inputmessage  = message.getPayload();
//		System.out.println("received message :"+inputmessage+", message size:"+inputmessage.length());
//	}
//    @Scheduled(fixedDelay = 2000)
//    public void sendMesssageTest(){
//
//        messageServiceImpl.sendMessage("KAFKA_ss_"+ LocalDateTime.now());
//        messageServiceImpl.sendMessage(LocalDateTime.now().plusDays(1));
//        System.out.println("sned message done");
//    }
}
