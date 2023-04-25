package com.example.vizsgaremek_autok;

public class LogiResponse {
    private int id;
    private String token;

    public LogiResponse(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
