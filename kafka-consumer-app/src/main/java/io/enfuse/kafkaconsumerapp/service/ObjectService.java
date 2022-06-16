package io.enfuse.kafkaconsumerapp.service;


import io.enfuse.kafkaconsumerapp.domain.ContentMessage;

import java.io.IOException;

public interface ObjectService {

    void save(ContentMessage storageObject) throws IOException;

    public ContentMessage getContent(String path);

}
