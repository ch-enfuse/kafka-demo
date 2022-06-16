package io.enfuse.kafkaconsumerapp.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.enfuse.kafkaconsumerapp.domain.ContentMessage;
import io.enfuse.kafkaconsumerapp.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.swing.text.AbstractDocument;
import java.security.MessageDigest;

@Component
public class ContentConsumer {

    @Autowired
    ObjectService objectService;

//    @Autowired
//    ObjectMapper objectMapper;

    @KafkaListener(topics = "content-object-v2")
    public void processMessage(String msg) throws JsonProcessingException {
        System.out.println("Message received: " + msg);
//        ContentMessage contentMessage = objectMapper.readValue(msg, ContentMessage.class);
//        System.out.println("Message received: " + contentMessage);
        try{
            objectService.save(new ContentMessage("chr/file.txt", msg));
        }
        catch (Exception e){
//            System.out.println(String.format("message %s not saved", msg.getContent()));
            System.out.println(String.format("message %s not saved", msg));

        }
    }
}
