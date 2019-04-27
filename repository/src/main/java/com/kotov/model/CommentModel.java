package com.kotov.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comments")
public class CommentModel implements Serializable {

    private static final long serialVersionUID = 7292977697458781532L;


    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_message", columnDefinition = "text")
    private String message;

    @ManyToOne
    @JoinColumn(name = "C_user_id")
    private UserModel usermODEL;



}
