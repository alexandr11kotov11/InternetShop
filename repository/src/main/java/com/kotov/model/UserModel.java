package com.kotov.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 4367552545254505353L;

    @Id
    @Column(name="u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="u_name")
    private String fullName;

    @Column(name="u_mail")
    private String mail;

    @Column(name="u_phone")
    private String phone;

    @Column(name="u_password")
    private String password;

    @Column(name="u_is_active")
    private Boolean isActive;

    @Column(name="u_address")
    private String address;

    @Column(name="u_add_info")
    private String addInfo;

    @Column(name="f_role", columnDefinition = "enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleModel roleModel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OrderModel> orders = new ArrayList<>();


    public static long getSerialVersionUID() {
         return serialVersionUID;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }
}
