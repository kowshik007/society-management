package com.application.start.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "society")
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private short status;
    @Column(name = "createdTimestamp")
    @CreationTimestamp
    private OffsetDateTime createdTimestamp;
    @Column(name = "updatedTimestamp")
    @UpdateTimestamp
    private OffsetDateTime updatedTimestamp;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY,targetEntity = Article.class)
    @JoinTable(
            name = "society_article",
            joinColumns = @JoinColumn(name = "societyid"),
            inverseJoinColumns = @JoinColumn(name = "articleid")
    )
    private Set articleList=new HashSet();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Category.class)
    @JoinTable(
            name = "society_category",
            joinColumns = @JoinColumn(name = "societyid"),
            inverseJoinColumns = @JoinColumn(name = "categoryid")
    )
    private Category category;

    public Society() {
    }

    public Society(String name, short status) {
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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

    public Set getArticleList() {
        return articleList;
    }

    public void setArticleList(Set articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Society{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }



    public void addSocietyArticle(Article article){
        if(articleList==null){
            articleList=new HashSet();
        }
        articleList.add(article);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
