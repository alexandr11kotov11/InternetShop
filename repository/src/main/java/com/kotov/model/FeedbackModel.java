package com.kotov.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "feedback")
public class FeedbackModel implements Serializable {
    private static final long serialVersionUID = 7292977697458781532L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Long id;

    @Column(name = "f_email")
    private String email;

    @Column(name = "f_message", columnDefinition = "text")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
