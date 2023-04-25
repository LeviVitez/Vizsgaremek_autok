package com.example.vizsgaremek_autok;

import javafx.beans.binding.ObjectBinding;

public class LoginModell extends ObjectBinding<LogiResponse> {
    private LogiResponse logiResponse;

    public LoginModell(LogiResponse logiResponse) {
        this.logiResponse = logiResponse;
    }

    public LogiResponse getLogiResponse() {
        return logiResponse;
    }

    @Override
    protected LogiResponse computeValue() {
        return logiResponse;
    }
}
