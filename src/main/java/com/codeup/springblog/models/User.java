package com.codeup.springblog.models;

import com.codeup.springblog.models.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")

    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public List<Post> getPosts() {

        return posts;
    }

    public void setPosts(List<Post> posts) {

        this.posts = posts;
    }
}
