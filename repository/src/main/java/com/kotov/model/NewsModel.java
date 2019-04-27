package com.kotov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "news")
public class NewsModel implements Serializable {

    private static final long serialVersionUID = -8517820276904825606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Long id;

    @Column(name = "n_date", columnDefinition = "date")
    private Date publicationDate;

    @Column(name = "n_title")
    private String newsTilte;

    @Column(name = "n_body", columnDefinition = "text")
    private String newsBody;

    @Column(name = "n_photo_uri")
    private String photoURI;

    @ManyToOne
    @JoinColumn(name = "n_user_id")
    private UserModel userModel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "n_news_id")
    private List<CommentModel> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getNewsTilte() {
        return newsTilte;
    }

    public void setNewsTilte(String newsTilte) {
        this.newsTilte = newsTilte;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getPhotoURI() {
        return photoURI;
    }

    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
