package application.model.viewmodel.productdetail;

import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class ProductDetailVM {
    private ProductVM productVM;
    private List<ProductVM> productVMList;

    public ProductVM getProductVM() {
        return productVM;
    }

    public void setProductVM(ProductVM productVM) {
        this.productVM = productVM;
    }

    public List<ProductVM> getProductVMList() {
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }
}
