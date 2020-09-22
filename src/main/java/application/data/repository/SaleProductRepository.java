package application.data.repository;

import application.data.model.Product;
import application.data.model.SaleProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


}
