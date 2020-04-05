package com.application.start.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "home_villa")
public class Villa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "villaname")
    private String villaName;
    @Column(name = "villadescription")
    private String villaDescription;
    @OneToMany(mappedBy = "villa",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = VillaDelivery.class)
    private Set villaDelivery=new HashSet();
    @Column(name = "createdtimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedtimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},targetEntity = GatedCommunity.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "gatedcommunityid")
    private GatedCommunity gatedCommunity;

    public Villa() {
    }

    public Villa(String villaName, String villaDescription) {
        this.villaName = villaName;
        this.villaDescription = villaDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVillaName() {
        return villaName;
    }

    public void setVillaName(String villaName) {
        this.villaName = villaName;
    }

    public String getVillaDescription() {
        return villaDescription;
    }

    public void setVillaDescription(String villaDescription) {
        this.villaDescription = villaDescription;
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

    public GatedCommunity getGatedCommunity() {
        return gatedCommunity;
    }

    public void setGatedCommunity(GatedCommunity gatedCommunity) {
        this.gatedCommunity = gatedCommunity;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id=" + id +
                ", villaName='" + villaName + '\'' +
                ", villaDescription='" + villaDescription + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
