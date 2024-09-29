package com.stacktips.transient_field;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private transient String password; // will not be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}
