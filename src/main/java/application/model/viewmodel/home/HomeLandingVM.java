package application.model.viewmodel.home;


import application.model.viewmodel.common.BannerVM;
import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class HomeLandingVM {
    private List<BannerVM> BannerVMs;
    private List<ProductVM> productVMs;
    private List<CategoryVM> categoryVMs;
    private List<ProductVM> productVMList;
    private List<ProductVM> productTopSellingVMs;
    private List<ProductVM> productNewVMs;

    private String keyWord;

    public List<ProductVM> getProductNewVMs() {
        return productNewVMs;
    }

    public void setProductNewVMs(List<ProductVM> productNewVMs) {
        this.productNewVMs = productNewVMs;
    }

    public List<BannerVM> getBannerVMs() {
        return BannerVMs;
    }

    public void setBannerVMs(List<BannerVM> bannerVMs) {
        BannerVMs = bannerVMs;
    }

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

     public List<ProductVM> getProductTopSellingVMs() {
        return productTopSellingVMs;
    }

    public void setProductTopSellingVMs(List<ProductVM> productTopSellingVMs) {
        this.productTopSellingVMs = productTopSellingVMs;
    }

    public List<ProductVM> getProductVMList() { 
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }
}
