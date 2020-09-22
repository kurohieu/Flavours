package application.data.service;

import application.data.model.Sale;
import application.data.repository.ProductRepository;
import application.data.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {


    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addNewListSales(List<Sale> sale){
        saleRepository.save(sale);
    }

    public void addNewSale(Sale sale) {

        saleRepository.save(sale);
    }
    public Sale findOne(int saleId) {
        return saleRepository.findOne(saleId);
    }

    public boolean updateSale(Sale sale){
        try {
            saleRepository.save(sale);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteSale(int saleId) {
        try {
            saleRepository.delete(saleId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Sale> getListAllSales() {
        try {
            return saleRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

