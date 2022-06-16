package io.enfuse.kafkaconsumerapp.service;

import io.enfuse.kafkaconsumerapp.domain.ContentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class AzureObjectService implements ObjectService {

    @Autowired
    private final ResourceLoader resourceLoader;
    //    In Azure you have storage-account which has containers, tables, etc. We are only using object-containers.
    private final String container;

    public AzureObjectService(ResourceLoader resourceLoader, @Value("${azure.container}") String container) {
        this.resourceLoader = resourceLoader;
        this.container = container;
    }

    @Override
    public void save(ContentMessage storageObject) throws IOException {
        Resource storageBlobResource = resourceLoader.getResource(String.format("azure-blob://%s/%s", container, storageObject.getKey()));
        try (OutputStream os = ((WritableResource) storageBlobResource).getOutputStream()) {
            os.write(storageObject.getContent().getBytes());
        }
    }

    @Override
    public ContentMessage getContent(String path) {
        return null;
    }

    private String createAzurePath(Resource resource) throws IOException {
        return String.format("azure-blob:/%s", resource.getURI().getPath());
    }
}
