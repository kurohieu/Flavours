package application.data.service;


import application.data.model.SaleProduct;
import application.data.repository.ProductRepository;
import application.data.repository.SaleProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class SaleProductService {

    @Autowired
    private SaleProductRepository saleProductRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addNewSaleProduct(SaleProduct saleProduct) {
        saleProductRepository.save(saleProduct);
    }

    @Transactional
    public void addNewListSaleProducts(List<SaleProduct> saleProduct) {
        saleProductRepository.save(saleProduct);
    }

    public SaleProduct findOne(int saleProductId) {
        return saleProductRepository.findOne(saleProductId);
    }

    public boolean updateSaleProduct(SaleProduct saleProduct) {
        try {
            saleProductRepository.save(saleProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSaleProduct(int saleProductId) {
        try {
            saleProductRepository.delete(saleProductId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public SaleProduct findSaleProductByProductIdAndCurrentDate(Integer productId, Date currentDate){
         return saleProductRepository.findSaleProductByProductIdAndCurrentDate(productId,currentDate);
     }

 }
