package com.dao.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category{

    private static final String CATEGORY_SEQUENCE = "category_id_seq";

    @Id
    @Column (name ="id")
    @SequenceGenerator(name = "categories_generator", sequenceName = CATEGORY_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_generator")
    private int id;
    @Column (name = "category")
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Data> data;


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return this.id;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getCategory() {
        return this.category;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return this.id + " " + this.category;
    }
}
