package application.data.model;

import javax.persistence.*;

@Entity(name = "db_cart_product")
public class CartProduct {

    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "cart_product_id")
    @Id
    private int id;

    @Column(name = "cart_id",nullable = false,updatable = false,insertable = false)
    private int cartId;

    @Column(name = "product_id",nullable = false,updatable = false,insertable = false)
    private int productId;

    @Column(name = "amount",nullable = false)
    private int amount;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
