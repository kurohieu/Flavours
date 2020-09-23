package application.data.repository;

import application.data.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {

    @Query("SELECT p " +
            "FROM db_sale_product p " +
            "JOIN p.sale s " +
            "WHERE p.productId = :productId " +
            "AND :currentDate BETWEEN s.startDate AND s.endDate")
    SaleProduct findSaleProductByProductIdAndCurrentDate(@Param("productId") Integer productId,
                                                         @Param("currentDate") Date currentDate);




 @Query(value="SELECT * FROM  FROM db_sale_product  sp \n" +
            "INNER JOIN db_product p ON p.product_id = sp.product_id\n" +
            "INNER JOIN db_sale s ON sp.sale_id = s.sale_id\n" +
            "WHERE p.product_id = ?1 AND start_date <= (SELECT CURDATE()) AND (end_date) >= (SELECT CURDATE())",
            nativeQuery= true)
List<SaleProduct> getProductBySale(int product_id);
}
