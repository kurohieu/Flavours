package application.data.model;


import javax.persistence.*;
import java.util.*;

@Entity(name = "db_product")
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @Id
    private int id;

    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductImage> productImageList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<CartProduct> cartProducts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<OrderProduct> orderProducts = new ArrayList<>();


    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "price")
    private Double price;

    @Column(name = "sale_price" ,nullable = false)
    private Double salePrice;

    @Column(name = "sale_percent",nullable = false)
    private Integer salePercent;

    @Column(name = "created_date")
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
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

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Integer salePercent) {
        this.salePercent = salePercent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
