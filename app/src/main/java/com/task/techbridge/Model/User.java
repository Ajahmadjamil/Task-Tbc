package com.task.techbridge.Model;

import java.util.List;

public class User {
    public String name, phone, email;
    public List<String> posts; // List to store post IDs

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;}


    public User(String name, String phone, String email, List<String> posts) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.posts = posts;
    }

    // Getter and setter methods for posts list
    public List<String> getPosts() {
        return posts;
    }

    public void setPosts(List<String> posts) {
        this.posts = posts;
    }
}

