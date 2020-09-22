package application.data.service;

import application.data.model.CartProduct;
import application.data.repository.CartProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartProductService {

    private static final Logger logger = LogManager.getLogger(CartProductService.class);

    @Autowired
    private CartProductRepository cartProductRepository;

    public void addNewCartProduct(CartProduct cartProductModel) {
        cartProductRepository.save(cartProductModel);
    }

    public boolean updateCartProduct(CartProduct cartProductModel) {
        try {
            cartProductRepository.save(cartProductModel);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public CartProduct findOne(int cartProductModelId) {
        return cartProductRepository.findOne(cartProductModelId);
    }

    public boolean deleteCartProduct(int cartProductModelId) {
        try {
            cartProductRepository.delete(cartProductModelId);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Transactional
    public boolean deleteListCartProducts(List<CartProduct> cartProductModels) {
        try {
            cartProductRepository.delete(cartProductModels);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public CartProduct findFirstCartProductByCartIdAndProductId(int cartId, int productId) {
        try {
            return cartProductRepository.findFirstCartProductByCartIdAndProductId(cartId,productId);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
