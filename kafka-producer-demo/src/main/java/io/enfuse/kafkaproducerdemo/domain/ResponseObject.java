package io.enfuse.kafkaproducerdemo.domain;

public class ResponseObject {
    private final String filePath;
    private final String content;
    private final String topic;

    public ResponseObject(String filePath, String content, String topic) {
        this.filePath = filePath;
        this.content = content;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getTopic() {
        return topic;
    }
}
