package application.model.viewmodel.productdetail;


import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class ProductDetailVM {
    private ProductVM productVM;
    private List<ProductVM> productVMs;


    public ProductVM getProductVM() {
        return productVM;
    }

    public void setProductVM(ProductVM productVM) {
        this.productVM = productVM;
    }

    public List<ProductVM> getProductVMs() {
        return productVMs;
    }

    public void setProductVMs(List<ProductVM> productVMs) {
        this.productVMs = productVMs;
    }


}
