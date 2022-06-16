package io.enfuse.kafkaproducerdemo.domain;


public class ContentMessage {
    private String key;
    private String content;

    public ContentMessage() {
    }

    public ContentMessage(String key, String content) {
        this.key = key;
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
