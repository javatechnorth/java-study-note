package com.liuyuanjiang.kafka.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaSource {
    String OUTPUT = "output";

    @Output(KafkaSource.OUTPUT)
    MessageChannel output();
}
