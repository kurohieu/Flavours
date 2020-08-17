package application.data.service;

import application.data.model.Product;
import application.data.repository.OrderProductRepository;
import application.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void addNewListProducts(List<Product> listProducts) {
        productRepository.save(listProducts);
    }

    public Product findOne(int productId) {
        return productRepository.findOne(productId);
    }


    public boolean updateProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Product> getListAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public long getTotalProducts(){
        return productRepository.getTotalProducts();
    }

    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    public Page<Product> getListProductByCategoryOrProductNameContaining(Pageable pageable, Integer categoryId,Double priceMin, Double priceMax, String productName){
        return productRepository.getListProductByCategoryOrProductNameContaining(pageable,categoryId,priceMin,priceMax,productName);
    }
    public List<Integer> getTopSellingProductId(){
        return orderProductRepository.getTopSellingProductId();
    }

    public List<Product> getListProductByCategoryId(Integer categoryId){
        return productRepository.getListProductByCategoryId(categoryId);
    }

    public List<Product> getListLatestProducts(){
        return productRepository.getListLatestProducts();
    }
}