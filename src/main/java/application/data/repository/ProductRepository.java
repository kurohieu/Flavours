package application.data.repository;

import application.data.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select count(p.id) from db_product p")
    long getTotalProducts();

    @Query("SELECT p FROM db_product p " +
            "WHERE (:categoryId IS NULL OR (p.categoryId = :categoryId))" +
            "AND (:productName IS NULL OR UPPER(p.name) LIKE CONCAT('%',UPPER(:productName),'%'))")
    Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable, @Param("categoryId") Integer categoryId, @Param("productName") String productName);






    @Query("SELECT p FROM db_product p WHERE p.categoryId = :categoryId")
    List<Product> getListProductByCategoryId(@Param("categoryId") Integer categoryId);

    @Query(value = "SELECT * FROM db_product p ORDER BY p.created_date DESC LIMIT 10", nativeQuery = true)
    List<Product> getListNewProduct();

}
