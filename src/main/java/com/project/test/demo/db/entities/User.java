package com.project.test.demo.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public User() {
        super();
    }

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;
    
    @Column(name = "status")
    private Integer status;

    @Column(name = "role")
    private String role;

    @Column(name = "position")
    private Integer position;


    public User(int id, String firstname ,String name , String telephone , String email , Integer status , String role , Integer position)
    {
        this.id = id;
        this.firstname = firstname;
        this. name = name;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.role = role;
        this.position = position;
    }

    public User(String firstname ,String name , String telephone , String email , Integer status , String role , Integer position)
    {
        this.firstname = firstname;
        this. name = name;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.role = role;
        this.position = position;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
