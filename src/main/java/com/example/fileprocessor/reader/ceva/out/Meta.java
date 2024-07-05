package com.example.fileprocessor.reader.ceva.out;

import lombok.AllArgsConstructor;

public class Meta {

    private String channel;
    private String nipSessionId;

    public Meta(String channel, String sessId) {
        this.channel = channel;
        this.nipSessionId = sessId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNipSessionId() {
        return nipSessionId;
    }

    public void setNipSessionId(String nipSessionId) {
        this.nipSessionId = nipSessionId;
    }
}
