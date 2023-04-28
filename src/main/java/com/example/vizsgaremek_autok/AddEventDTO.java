package com.example.vizsgaremek_autok;

public class AddEventDTO {
    private String title;
    private String start;
    private String comment;

    public AddEventDTO(String title, String start, String comment) {
        this.title = title;
        this.start = start;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
