package application.data.service;

import application.data.model.ProductImage;
import application.data.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductImageService {


    @Autowired
    private ProductImageRepository productImageRepository;

    @Transactional
    public void addNewListProductImages(List<ProductImage> productModelImages) {
        try {
            productImageRepository.save(productModelImages);
        } catch (Exception e) {
        }
    }

    public void addNewProductImage(ProductImage productModelImage) {
        try {
            productImageRepository.save(productModelImage);
        } catch (Exception e) {
        }
    }

    public ProductImage findOne(int productModelImage) {
        return productImageRepository.findOne(productModelImage);
    }

    public boolean updateProductImage(ProductImage productModelImage) {
        try {
            productImageRepository.save(productModelImage);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteProductImage(int productModelImage) {
        try {
            productImageRepository.delete(productModelImage);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
