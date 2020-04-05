package com.application.start.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "society_user")
public class UserSociety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userid")
    private int userid;
    @Column(name = "societyid")
    private int societyid;
    @Column(name = "createdTimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedTimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;
    public UserSociety() {
    }

    public UserSociety(int userid, int societyid) {
        this.userid = userid;
        this.societyid = societyid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSocietyid() {
        return societyid;
    }

    public void setSocietyid(int societyid) {
        this.societyid = societyid;
    }

    @Override
    public String toString() {
        return "UserSociety{" +
                "id=" + id +
                ", userid=" + userid +
                ", societyid=" + societyid +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
