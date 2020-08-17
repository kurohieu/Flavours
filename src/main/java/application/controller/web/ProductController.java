//package application.controller.web;
//
//import application.data.model.Product;
//import application.data.model.ProductImage;
//import application.data.service.ProductService;
//import application.model.viewmodel.common.ProductImageVM;
//import application.model.viewmodel.common.ProductVM;
//import application.model.viewmodel.productdetail.ProductDetailVM;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.security.Principal;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping(path = "/product")
//public class ProductController extends BaseController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/{productId}")
//    public String productDetail(Model model,
//                                @PathVariable Integer productId,
//                                @Valid @ModelAttribute("product") ProductVM product,
//                                HttpServletResponse response,
//                                HttpServletRequest request,
//                                final Principal principal) {
//
//
//        this.checkCookie(response, request, principal);
//        ProductDetailVM vm = new ProductDetailVM();
//        DecimalFormat df = new DecimalFormat("##,###,###");
//        String guid = getGuid(request);
//
//        Product productEntity = productService.findOne(productId);
//        ProductVM productVM = new ProductVM();
//
//        if (productEntity != null) {
//            productVM.setId(productEntity.getId());
//            productVM.setName(productEntity.getName());
//            productVM.setMainImage(productEntity.getMainImage());
//            productVM.setShortDesc(productEntity.getShortDesc());
//            productVM.setPrice(productEntity.getPrice());
//
////        if(productEntity!=null) {
////            productVM.setId(productEntity.getId());
////            productVM.setName(productEntity.getName());
////            productVM.setMainImage(productEntity.getMainImage());
////            productVM.setShortDesc(productEntity.getShortDesc());
////            productVM.setPrice(df.format(productEntity.getPrice()));
////            if (productEntity.getPrice()!=setPriceVM(productEntity)){
////                productVM.setHasSale(true);
////                productVM.setPriceSale(df.format(setPriceVM(productEntity)));
////            }else {
////                productVM.setHasSale(false);
////            }
////            productVM.setAmount(productEntity.getAmount());
////            productVM.setCategoryName(productEntity.getCategory().getName());
//            /**
//             * set list product image vm
//             */
//            List<ProductImageVM> productImageVMS = new ArrayList<>();
//            for (ProductImage productImage : productEntity.getProductImageList()) {
//                ProductImageVM productImageVM = new ProductImageVM();
//                productImageVM.setLink(productImage.getLink());
//
//                productImageVMS.add(productImageVM);
//            }
//
//            productVM.setProductImageVMS(productImageVMS);
//
//
//            vm.setProductVM(productVM);
//
//            model.addAttribute("vm", vm);
//
//            return "/product-detail";
//        }
//
//    }





package application.controller.web;

import application.data.model.Product;
import application.data.model.ProductImage;
import application.data.service.ProductService;
import application.model.viewmodel.common.ProductImageVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.productdetail.ProductDetailVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model,
                                @Valid @ModelAttribute("productname") ProductVM productName) {

        ProductDetailVM vm = new ProductDetailVM();
        DecimalFormat df = new DecimalFormat("##,###,###");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Product productEntity = productService.findOne(productId);
        ProductVM productVM = new ProductVM();

        if(productEntity!=null) {
            productVM.setId(productEntity.getId());
            productVM.setName(productEntity.getName());
            productVM.setMainImage(productEntity.getMainImage());
            productVM.setShortDesc(productEntity.getShortDesc());
            productVM.setPrice(df.format(productEntity.getPrice()));




            /**
             * set list product image vm
             */
            List<ProductImageVM> productImageVMS = new ArrayList<>();
            for(ProductImage productImage : productEntity.getProductImageList()) {
                ProductImageVM productImageVM = new ProductImageVM();
                productImageVM.setLink(productImage.getLink());

                productImageVMS.add(productImageVM);
            }

            productVM.setProductImageVMS(productImageVMS);
        }



        vm.setProductVM(productVM);

        model.addAttribute("vm",vm);

        return "/product-detail";
    }

}
