package application.model.viewmodel.admin;

import application.model.viewmodel.common.CategoryVM;

import java.util.List;

public class AdminCategoryVM {

    private List<CategoryVM> categoryVMs;
    private String keyWord;


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
