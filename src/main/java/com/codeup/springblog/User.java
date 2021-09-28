package com.codeup.springblog;

import com.codeup.springblog.models.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")

    private List<Post> posts;
}
