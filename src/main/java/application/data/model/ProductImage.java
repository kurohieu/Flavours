package application.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "db_product_image")
public class ProductImage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_image_id")
    @Id
    private int id;

    @Column(name = "product_id",updatable = false,insertable = false,nullable = false)
    private int productId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "link",nullable = false)
    private String link;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
