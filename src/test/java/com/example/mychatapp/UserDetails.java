package com.example.mychatapp;
public class UserDetails {
    static String username = "";
    static String chatWith = "";
    public UserDetails(String username, String chatWith) {
        this.username=username;
        this.chatWith=chatWith;

    }

    public String getUsername() {
        return username;
    }

    public String chatWith() {
        return chatWith;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void chatWith(String chatWith) {
        this.chatWith= chatWith;
    }
}