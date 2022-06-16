package io.enfuse.kafkaproducerdemo.controllers;

import io.enfuse.kafkaproducerdemo.domain.ContentMessage;
import io.enfuse.kafkaproducerdemo.domain.ResponseObject;
import io.enfuse.kafkaproducerdemo.kafka.ContentProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import javax.swing.text.AbstractDocument;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
public class ContentMessageController {

    private final ContentProducerService contentProducerService;

    public ContentMessageController(ContentProducerService contentProducerService) {
        this.contentProducerService = contentProducerService;
    }

    @PostMapping(path = "/publish", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObject> publishMessage(@RequestBody ContentMessage request) throws IOException {
        return new ResponseEntity<ResponseObject>(contentProducerService.produceMessage(request), HttpStatus.OK);
    }
}
