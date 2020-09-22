package application.model.viewmodel.admin;

import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.LayoutHeaderAdminVM;
import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class AdminProductVM {

    private List<ProductVM> productVMs;
    private List<CategoryVM> categoryVMs;



    public List<ProductVM> getProductVMs() {
        return productVMs;
    }

    public void setProductVMs(List<ProductVM> productVMs) {
        this.productVMs = productVMs;
    }

    public List<CategoryVM> getCategoryVMs() {
        return categoryVMs;
    }

    public void setCategoryVMs(List<CategoryVM> categoryVMs) {
        this.categoryVMs = categoryVMs;
    }

}
