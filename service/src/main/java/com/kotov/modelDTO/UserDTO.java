package com.kotov.modelDTO;


import com.kotov.model.RoleModel;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 3266550439610719796L;

    private Long id;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String fullName;

    @Email(message = "{reg.user.mail.invalid}")
    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String mail;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String phone;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String address;

    @NotNull
    @Size(min = 7, max = 20, message = "{reg.user.passwordNotInRange}")
    private String password;

    @NotNull
    private String confirmPassword;
    private Boolean isActive;

    @Size(max = 2000, message = "{reg.user.tooLongValue}")
    private String addInfo;
    private RoleModel role;
    private List<OrderDTO> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> order) {
        this.orders = orders;
    }
}
