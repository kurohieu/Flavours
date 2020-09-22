package application.data.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "db_category")
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    @Id
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products= new HashSet<>();

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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
