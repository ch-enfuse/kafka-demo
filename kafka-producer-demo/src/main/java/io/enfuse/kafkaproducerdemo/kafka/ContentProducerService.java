package io.enfuse.kafkaproducerdemo.kafka;

import io.enfuse.kafkaproducerdemo.domain.ContentMessage;
import io.enfuse.kafkaproducerdemo.domain.ResponseObject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContentProducerService {

    @Autowired
    private KafkaTemplate<String, ContentMessage> kafkaTemplate;

    private final String MESSAGE_CONTENT_TOPIC = "content-object-v2";
    public ResponseObject produceMessage(ContentMessage msg){
        kafkaTemplate.send(MESSAGE_CONTENT_TOPIC, msg);
        System.out.println("Message sent: " + msg);
        return new ResponseObject(msg.getKey(), msg.getContent(), MESSAGE_CONTENT_TOPIC);
    }
}
