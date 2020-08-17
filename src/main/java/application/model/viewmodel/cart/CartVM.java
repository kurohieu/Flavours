package application.model.viewmodel.cart;

import java.util.List;

public class CartVM {

    private int productAmount;
    private List<CartProductVM> cartProductVMS;
    private String totalPrice;

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public List<CartProductVM> getCartProductVMS() {
        return cartProductVMS;
    }

    public void setCartProductVMS(List<CartProductVM> cartProductVMS) {
        this.cartProductVMS = cartProductVMS;
    }



    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
