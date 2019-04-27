package com.kotov.model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")

public class OrderModel implements Serializable {
    private static final long serialVersionUID = -8517820276904825606L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="o_id")
    private Long id;

    @Column(name="o_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "o_user_id")
    private UserModel userModel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "o_order_id")
    private List<OrderPositionModel> orderPositionsModel = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<OrderPositionModel> getOrderPositionsModel() {
        return orderPositionsModel;
    }

    public void setOrderPositionsModel(List<OrderPositionModel> orderPositionsModel) {
        this.orderPositionsModel = orderPositionsModel;
    }
}
