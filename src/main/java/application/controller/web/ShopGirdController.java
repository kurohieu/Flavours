package application.controller.wep;

import application.data.model.Category;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.ProductVM;
import application.model.viewmodel.home.HomeLandingVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ShopGirdController {



        @Autowired
        private CategoryService categoryService;
        @Autowired
        private ProductService productService;

        @GetMapping("/shop-grid")
        public String home(Model model,
                           @Valid @ModelAttribute("product") ProductVM productName,
                           @RequestParam(name = "categoryId", required = false) Integer categoryId,
                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "priceMin",required = false) Double priceMin,
                           @RequestParam(name = "priceMax",required = false) Double priceMax,
                           @RequestParam(name = "size", required = false, defaultValue = "9") Integer size,
                           @RequestParam(name = "sortByPrice", required = false) String sort,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           final Principal principal) {

            HomeLandingVM vm = new HomeLandingVM();
            DecimalFormat df = new DecimalFormat("##,###,###");

            List<Category> categorys = categoryService.getListAllCategories();
            List<CategoryVM> categoryVMs = new ArrayList<>();

            for (Category category : categorys) {
                CategoryVM categoryVM = new CategoryVM();
                categoryVM.setId(category.getId());
                categoryVM.setName(category.getName());
                categoryVMs.add(categoryVM);
            }
            /*set list productVM*/


            Sort sortable = new Sort(Sort.Direction.ASC, "id");
            if (sort != null) {
                if (sort.equals("ASC")) {
                    sortable = new Sort(Sort.Direction.ASC, "price");
                } else {
                    sortable = new Sort(Sort.Direction.DESC, "price");
                }
            }

            Pageable pageable = new PageRequest(page, size, sortable);
            Page<Product> productPage;
            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable,categoryId,priceMin,priceMax,productName.getName());
//            if (categoryId != null) {
//                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, categoryId, null);
//                Category category = categoryService.findOne(categoryId);
//                vm.setKeyWord(category.getName());
//            } else if (productName.getName() != null && !productName.getName().isEmpty()) {
//                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null, productName.getName().trim());
//                vm.setKeyWord("Find with key: " + productName.getName());
//            } else {
//                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null, null);
//            }

            List<ProductVM> productVMs = new ArrayList<>();

            for (Product productEntity : productPage.getContent()) {
                ProductVM productVM = new ProductVM();
                productVM.setId(productEntity.getId());
                productVM.setName(productEntity.getName());
                productVM.setMainImage(productEntity.getMainImage());
                productVM.setPrice(df.format(productEntity.getPrice()));
                productVM.setCategoryName(productEntity.getCategory().getName());

                productVM.setCreatedDate(productEntity.getCreatedDate());

                productVMs.add(productVM);
            }

            /**
             * set vm
             */

            vm.setCategoryVMList(categoryVMs);
            vm.setProductVMList(productVMs);

            model.addAttribute("vm", vm);
            model.addAttribute("page",productPage);
            return "/shop-gird";
        }
    }




