package application.model.viewmodel.admin;

import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.LayoutHeaderAdminVM;

import java.util.List;

public class AdminCategoryVM {

    private List<CategoryVM> categoryVMs;

    public List<CategoryVM> getCategoryVMs() {
        return categoryVMs;
    }

    public void setCategoryVMs(List<CategoryVM> categoryVMs) {
        this.categoryVMs = categoryVMs;
    }
}
