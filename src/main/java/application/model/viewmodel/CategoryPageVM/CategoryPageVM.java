package application.model.viewmodel.CategoryPageVM;

import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class CategoryPageVM {
    private List<ProductVM> productVMs;
    private List<CategoryVM> categoryVMs;

    private String keyWord;


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



    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }


}
