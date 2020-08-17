package application.model.viewmodel.home;

import application.model.viewmodel.blog.BlogVM;
import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.ProductVM;

import java.util.List;

public class HomeLandingVM {
    private List<BannerVM> listBanners;
    private List<ProductVM> productVMList;
    private List<CategoryVM> categoryVMList;
    private List<ProductVM> productTopSellingVMs;
    private  List<ProductVM> LatestProductsVMs;
    private String keyWord;
    private List<BlogVM> BlogVMList;

    public List<BlogVM> getBlogVMList() {
        return BlogVMList;
    }

    public void setBlogVMList(List<BlogVM> blogVMList) {
        BlogVMList = blogVMList;
    }

    public List<BannerVM> getListBanners() {
        return listBanners;
    }

    public void setListBanners(List<BannerVM> listBanners) {
        this.listBanners = listBanners;
    }

    public List<ProductVM> getProductVMList() {
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }

    public List<CategoryVM> getCategoryVMList() {
        return categoryVMList;
    }

    public void setCategoryVMList(List<CategoryVM> categoryVMList) {
        this.categoryVMList = categoryVMList;
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

    public List<ProductVM> getLatestProductsVMs() {
        return LatestProductsVMs;
    }

    public void setLatestProductsVMs(List<ProductVM> latestProductsVMs) {
        LatestProductsVMs = latestProductsVMs;
    }
}
