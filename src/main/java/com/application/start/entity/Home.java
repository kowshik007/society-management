package com.application.start.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER,targetEntity = Floor.class)
    @JoinColumn(name = "floorid")
    private Floor floor;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Delivery.class)
    @JoinColumn(name = "homeid")
    private Set homeDelivery=new HashSet();
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Member.class
    )
    @JoinColumn(name = "homeid")
    private Set members=new HashSet();
    @Column(name = "flatnumber")
    private int flatNumber;
    @Column(name = "createdtimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedtimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;

    public Home() {
    }

    public Home(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set getMembers() {
        return members;
    }

    public void setMembers(Set members) {
        this.members = members;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
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

    public Set getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(Set homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    private void addHomeDelivery(Delivery delivery){
        if(homeDelivery==null){
            homeDelivery=new HashSet();
        }
        homeDelivery.add(delivery);
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", flatNumber=" + flatNumber +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
