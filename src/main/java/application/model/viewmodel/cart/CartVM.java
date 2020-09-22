package application.model.viewmodel.cart;

import java.util.List;

public class CartVM {

    private int productAmount;
    private List<CartProductVM> cartProductVMs;
    private String totalPrice;

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public List<CartProductVM> getCartProductVMs() {
        return cartProductVMs;
    }

    public void setCartProductVMs(List<CartProductVM> cartProductVMs) {
        this.cartProductVMs = cartProductVMs;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
