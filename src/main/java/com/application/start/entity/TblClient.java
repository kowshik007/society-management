package com.application.start.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "tbl_client")
public class TblClient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "clientuserid")
    private String clientUserId;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @OneToMany(targetEntity = TblAuthority.class,cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_client_authority",
    joinColumns = @JoinColumn(name = "clientId"),
    inverseJoinColumns = @JoinColumn(name = "authorityId"))
    private Set<TblAuthority> tblAuthoritySet;
    @OneToMany(targetEntity = TblScope.class,cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_client_scope",
    joinColumns = @JoinColumn(name = "clientid"),
    inverseJoinColumns = @JoinColumn(name = "scopeid"))
    private Set<TblScope> tblScopeSet;
    @Column(name = "createdtimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedtimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;

    public TblClient() {
    }

    public TblClient(String clientUserId, String password) {
        this.clientUserId = clientUserId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TblClient{" +
                "id=" + id +
                ", clientUserId='" + clientUserId + '\'' +
                ", password='" + password + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(String clientUserId) {
        this.clientUserId = clientUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<TblAuthority> getTblAuthoritySet() {
        return tblAuthoritySet;
    }

    public void setTblAuthoritySet(Set<TblAuthority> tblAuthoritySet) {
        this.tblAuthoritySet = tblAuthoritySet;
    }

    public Set<TblScope> getTblScopeSet() {
        return tblScopeSet;
    }

    public void setTblScopeSet(Set<TblScope> tblScopeSet) {
        this.tblScopeSet = tblScopeSet;
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
}
