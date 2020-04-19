package com.application.start.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "id_user")
public class IdUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "status")
    private short status;
    @Column(name = "active")
    private boolean active;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createdTimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedTimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER,targetEntity = Role.class)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private Set roleList=new HashSet();

//    @OneToMany(mappedBy = "user",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY,targetEntity = UserSecurity.class)
//    private Set userSecurityList=new HashSet();

    public IdUser() {
    }

    public IdUser(String email, String password, short status, boolean active, String phone) {
        this.email = email;
        this.password = password;
        this.status = status;
        this.active = active;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public OffsetDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(OffsetDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public void addRole(Role role){
        if(roleList==null){
            roleList=new HashSet();
        }
        roleList.add(role);
    }
//
//    public void addUserSecurity(UserSecurity userSecurity){
//        if(userSecurityList==null){
//            userSecurityList=new HashSet();
//        }
//        userSecurityList.add(userSecurity);
//    }



    public Set getRoleList() {
        return roleList;
    }

    public void setRoleList(Set roleList) {
        this.roleList = roleList;
    }

//    public Set getUserSecurityList() {
//        return userSecurityList;
//    }
//
//    public void setUserSecurityList(Set userSecurityList) {
//        this.userSecurityList = userSecurityList;
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", active=" + active +
                ", phone='" + phone + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
