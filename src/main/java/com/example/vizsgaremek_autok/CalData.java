package com.example.vizsgaremek_autok;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CalData {
    private List<EventResponse> eventResponses;

    public CalData() {
    }
@JsonProperty("calDatas")
    public List<EventResponse> getEventResponses() {
        return eventResponses;
    }

    public void setEventResponses(List<EventResponse> eventResponses) {
        this.eventResponses = eventResponses;
    }
}
