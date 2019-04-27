package com.kotov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "goods")
public class GoodsModel implements Serializable {

    private static final long serialVersionUID = -8517820276904825606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_id")
    private Long id;

    @Column(name="g_name")
    private String name;

    @Column(name="g_description", columnDefinition = "text")
    private String description;

    @Column(name="g_price")
    private BigDecimal price;

    @Column(name = "f_image_uri")
    private String imageURI;

    @Column(name="f_is_active", nullable = false)
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Column(name="g_presence")
    private Boolean isPresence;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public Boolean getPresence() {
        return isPresence;
    }

    public void setPresence(Boolean presence) {
        isPresence = presence;
    }
}
