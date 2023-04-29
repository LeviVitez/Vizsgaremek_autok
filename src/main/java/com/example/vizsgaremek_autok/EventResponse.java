package com.example.vizsgaremek_autok;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventResponse {
    private String title;
    private String start;
    private String comment;
    private int calId;

    public EventResponse() {
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }
    @JsonProperty("calId")
    public int getCalId() {
        return calId;
    }

}
