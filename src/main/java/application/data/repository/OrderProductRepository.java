package application.data.repository;

import application.data.model.OrderProduct;
import application.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {
    @Query(value = "SELECT op.product_id\n" +
            "\tFROM db_order_product op\n" +
            "\tGROUP BY op.product_id\n" +
            "\tORDER BY COUNT(op.amount) DESC \n" +
            "\tLIMIT 10", nativeQuery = true)
    List<Integer> getTopSellingProductId();
}
