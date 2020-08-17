package application.data.repository;

import application.data.model.CartProduct;
import application.data.model.Product;
import application.data.model.Review;
import application.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT r.star FROM db_review  r " +
            "WHERE r.product = :product")
    List<Integer> getRateByProduct(@Param("product") Product product);

    @Transactional(readOnly = true)
    @Query(value = "SELECT r.star FROM db_review  r  " +
            "WHERE r.product = :product AND r.userName = :userName ")
    List<Integer> getStarByProductAndUserName( @Param("product") Product product, @Param("userName") String userName);


    @Transactional(readOnly = true)
    @Query("select r from db_review r where r.product = :productId and r.userName = :userName ")
    Iterable<Review> findStarByProductAndUserName(@Param("productId") Product product, @Param("userName") String userName);
}