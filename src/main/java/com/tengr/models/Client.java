package com.tengr.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    private Long id;
    private String name;


    private Set<User> clientUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "userClient", cascade = CascadeType.ALL)
    public Set<User> getClientUsers() {
        return clientUsers;
    }
    public void setClientUsers(Set<User> clientUsers) {
        this.clientUsers = clientUsers;
    }
}
