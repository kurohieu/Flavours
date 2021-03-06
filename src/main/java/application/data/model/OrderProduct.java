package application.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "db_order_product")
public class OrderProduct {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_product_id")
    @Id
    private int id;

    @Column(name = "product_id",nullable = false,updatable = false,insertable = false)
    private int productId;

    @Column(name = "order_id",nullable = false,updatable = false,insertable = false)
    private int orderId;

    @Column(name = "amount",nullable = false)
    private int amount;

    @Column(name = "price",nullable = false)
    private double price;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
