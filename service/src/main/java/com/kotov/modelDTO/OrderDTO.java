package com.kotov.modelDTO;

import com.kotov.model.OrderStatusModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderDTO {

    private Long id;
    private OrderStatusModel status;
    private UserDTO user;
    private BigDecimal totalPrice;
    private boolean possibleToEdit;

    private Map<GoodsDTO, Integer> products = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatusModel getStatus() {
        return status;
    }

    public void setStatus(OrderStatusModel status) {
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPossibleToEdit() {
        return possibleToEdit;
    }

    public void setPossibleToEdit(boolean possibleToEdit) {
        this.possibleToEdit = possibleToEdit;
    }

    public Map<GoodsDTO, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<GoodsDTO, Integer> products) {
        this.products = products;
    }
}
