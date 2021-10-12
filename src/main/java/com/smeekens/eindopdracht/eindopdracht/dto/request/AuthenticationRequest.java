package com.smeekens.eindopdracht.eindopdracht.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationRequest {

    @NotEmpty
    private String username;

    @Size(min=8)
    private String password;

    public AuthenticationRequest() {
    }
    public AuthenticationRequest(String username, String passowrd) {
        this.username = username;
        this.password = passowrd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
