package application.controller.web;

import application.data.model.*;
import application.data.service.CartService;
import application.data.service.ProductService;
import application.model.viewmodel.cart.CartVM;
import application.model.viewmodel.common.ProductImageVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.productdetail.ProductDetailVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping(path = "/product")
public class ProductController extends BaseController{
    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;



    @GetMapping("/{productId}")
    public String productDetail(Model model,
                                @PathVariable Integer productId,
                                @Valid @ModelAttribute("product") ProductVM product,
                                HttpServletResponse response,
                                HttpServletRequest request,
                                final Principal principal) {


        this.checkCookie(response, request, principal);
        ProductDetailVM vm = new ProductDetailVM();
        DecimalFormat df = new DecimalFormat("##,###,###");
        String guid = getGuid(request);




        Product productEntity = productService.findOne(productId);
        ProductVM productVM = new ProductVM();

        if (productEntity != null) {
            productVM.setId(productEntity.getId());
            productVM.setName(productEntity.getName());
            productVM.setMainImage(productEntity.getMainImage());
            productVM.setShortDesc(productEntity.getShortDesc());
            productVM.setPrice(df.format(productEntity.getPrice()));
            if (productEntity.getPrice()!=setPriceVM(productEntity)){
                productVM.setHasSale(true);
                productVM.setPriceSale(df.format(setPriceVM(productEntity)));
            }else {
                productVM.setHasSale(false);
            }
            productVM.setCategoryName(productEntity.getCategory().getName());

            /*set list productImageVM*/


            List<ProductImageVM> productImageVMs = new ArrayList<>();
            for (ProductImage productModelImage : productEntity.getProductImages()) {
                ProductImageVM productModelImageVM = new ProductImageVM();
                productModelImageVM.setLink(productModelImage.getLink());

                productImageVMs.add(productModelImageVM);
            }

            productVM.setProductImageVMs(productImageVMs);
        }
        List<Product> products = productService.getListProductByCategoryId(productEntity.getCategoryId());
        Set<Product> productRelateds = new HashSet<>();
        Random random = new Random();
        for (Product product1 : products){
            if (productRelateds.size()<6){
                productRelateds.add(products.get(random.nextInt(products.size())));
            }
            else{
                break;
            }
        }
        List<ProductVM> productVMs = new ArrayList<>();



        if (productRelateds != null) {
            for (Product productRelate : productRelateds) {
                ProductVM productVMRelate = new ProductVM();
                productVMRelate.setId(productRelate.getId());
                productVMRelate.setName(productRelate.getName());
                productVMRelate.setMainImage(productRelate.getMainImage());
                productVMRelate.setShortDesc(productRelate.getShortDesc());
                productVMRelate.setPrice(df.format(productRelate.getPrice()));
                if (productRelate.getPrice()!=setPriceVM(productRelate)){
                    productVMRelate.setHasSale(true);
                    productVMRelate.setPriceSale(df.format(setPriceVM(productRelate)));
                }else {
                    productVMRelate.setHasSale(false);
                }
                productVMRelate.setCategoryName(productRelate.getCategory().getName());
                productVMs.add(productVMRelate);
            }

        }
        /*CartVM*/
        CartVM cartVM = setCartVM(guid);



        vm.setProductVM(productVM);
        vm.setProductVMs(productVMs);



        model.addAttribute("cartVM", cartVM);
        model.addAttribute("vm", vm);

        return "/product-detail";
    }


}
