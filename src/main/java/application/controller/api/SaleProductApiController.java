package application.controller.api;


import application.data.model.Product;
import application.data.model.Sale;
import application.data.model.SaleProduct;
import application.data.service.ProductService;
import application.data.service.SaleProductService;
import application.data.service.SaleService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.SaleProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/sale-product")
public class SaleProductApiController {
    private static final Logger logger = LogManager.getLogger(SaleProductApiController.class);
    @Autowired
    private  SaleProductService saleProductService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @GetMapping("/fake")
    public BaseApiResult fakeSaleProduct() {
        BaseApiResult result = new BaseApiResult();

        try {
            Random random = new Random();
            List<Product> products = productService.getListAllProducts();
            for (int i=0;i<=10;i++){
                products.add(products.get(random.nextInt(products.size())));
            }
            List<Sale> sales = saleService.getListAllSales();
            List<SaleProduct> saleProducts = new ArrayList<>();
            for (Product product:products){
                SaleProduct saleProduct = new SaleProduct();
                saleProduct.setProduct(product);
                saleProduct.setSale(sales.get(random.nextInt(sales.size())));
                saleProducts.add(saleProduct);
            }
            saleProductService.addNewListSaleProducts(saleProducts);
            result.setSuccess(true);
            result.setMessage("Fake list saleProduct success !");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }



    @PostMapping(value = "/create")
    public BaseApiResult createSaleProduct(@RequestBody SaleProductDTO dto){
        DataApiResult result = new DataApiResult();

        try {
            SaleProduct saleProduct = new SaleProduct();

            saleProduct.setProduct(productService.findOne(dto.getProductId()));
            saleProduct.setSale(saleService.findOne(dto.getId()));
            saleProductService.addNewSaleProduct(saleProduct);
            result.setData(saleProduct.getProductId());
            result.setMessage("Save sale product successfully: " + saleProduct.getProductId());
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update/{saleProductId}")
    public BaseApiResult updateCategory(@PathVariable int saleProductId,
                                        @RequestBody SaleProductDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            SaleProduct saleProduct = saleProductService.findOne(saleProductId);
            saleProduct.setProduct(productService.findOne(dto.getProductId()));
            saleProduct.setSale(saleService.findOne(dto.getId()));
            saleProductService.updateSaleProduct(saleProduct);
            result.setSuccess(true);
            result.setMessage("Update sale product successfully");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }
    @GetMapping("/detail/{saleProductId}")
    public BaseApiResult detailMaterial(@PathVariable int saleProductId){
        DataApiResult result= new DataApiResult();

        try {
            SaleProduct saleProductEntity = saleProductService.findOne(saleProductId);
            if (saleProductEntity == null) {
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            } else {
                SaleProductDTO dto = new SaleProductDTO();
                dto.setId(saleProductEntity.getProductId());
                if(saleProductEntity.getProduct() != null) {
                    dto.setProductId(saleProductEntity.getProduct().getId());
                }
                if(saleProductEntity.getSale() != null) {
                    dto.setId(saleProductEntity.getSaleId());
                }
                result.setSuccess(true);
                result.setData(dto);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }


}
