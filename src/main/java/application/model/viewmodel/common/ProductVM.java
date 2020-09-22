package application.model.viewmodel.common;

import java.util.Date;
import java.util.List;

public class ProductVM {
    private int id;
    private String categoryName;
    private String name;
    private String shortDesc;
    private String mainImage;
    private String price;
    private String priceSale;
    private Boolean hasSale;
    private Date createdDate;
    private int amount;
    private List<ProductImageVM> productImageVMs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public List<ProductImageVM> getProductImageVMs() {
        return productImageVMs;
    }

    public void setProductImageVMs(List<ProductImageVM> productImageVMs) {
        this.productImageVMs = productImageVMs;
    }


    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public Boolean getHasSale() {
        return hasSale;
    }

    public void setHasSale(Boolean hasSale) {
        this.hasSale = hasSale;
    }


}
