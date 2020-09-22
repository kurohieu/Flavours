package application.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "db_sale_product")
public class SaleProduct {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_product_id")
    @Id
    private int saleProductModelId;

    @Column(name = "sale_id",nullable = false,insertable = false,updatable = false)
    private int saleId;

    @Column(name = "product_id",nullable = false,insertable = false,updatable = false)
    private int productId;



    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public int getSaleProductModelId() {
        return saleProductModelId;
    }

    public void setSaleProductModelId(int saleProductModelId) {
        this.saleProductModelId = saleProductModelId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }



    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
