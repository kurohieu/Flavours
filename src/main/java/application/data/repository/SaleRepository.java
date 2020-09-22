package application.data.repository;

import application.data.model.Sale;
import application.data.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleRepository extends JpaRepository<Sale, Integer> {
    



}
