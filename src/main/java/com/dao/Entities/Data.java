package com.dao.Entities;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @Column(name ="id")
    private String key;

    @Column(name ="value")
    private String value;

    @ManyToOne
    private Category category;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
