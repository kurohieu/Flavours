package application.data.repository;

import application.data.model.Category;
import application.model.viewmodel.common.CategoryVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select count(c.id) from db_category c")
    long getTotalCategories();

    @Query("SELECT NEW application.model.viewmodel.common.CategoryVM(c.id, c.name, c.shortDesc ,c.createdDate) FROM db_category c")
    List<CategoryVM> getListAllCategoryVMs();
}
