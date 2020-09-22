package application.controller.web;

import application.data.model.*;
import application.data.service.*;
import application.model.viewmodel.CategoryPageVM.CategoryPageVM;
import application.model.viewmodel.cart.CartVM;
import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.common.ProductVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/grid")
public class GridController extends BaseController{
    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired

    private CartService cartService;


    @GetMapping("")
    public String home (Model model,
                        @Valid @ModelAttribute("product") ProductVM productName,
                        @RequestParam(name = "categoryId", required = false) Integer categoryId,
                        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "12") Integer size,
                        @RequestParam(name = "sortByPrice", required = false) String sort,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        final Principal principal) {

        this.checkCookie(response, request, principal);
        CategoryPageVM vm = new CategoryPageVM();
        DecimalFormat df = new DecimalFormat("##,###,###");
        String guid = getGuid(request);
        /**
         * set list categoryVM
         */
        List<Category> categorys = categoryService.getListAllCategories();
        List<CategoryVM> categoryVMs = new ArrayList<>();

        for (Category category : categorys) {
            CategoryVM categoryVM = new CategoryVM();
            categoryVM.setId(category.getId());
            categoryVM.setName(category.getName());
            categoryVMs.add(categoryVM);
        }

        /**
         * set list productVM
         */

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
        productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, categoryId,productName.getName());

        List<ProductVM> productVMs = new ArrayList<>();

        for (Product product : productPage.getContent()) {
            ProductVM productVM = new ProductVM();
            productVM.setId(product.getId());
            productVM.setName(product.getName());
            productVM.setMainImage(product.getMainImage());
            productVM.setPrice(df.format(product.getPrice()));
            if (product.getPrice()!=setPriceVM(product)){
                productVM.setHasSale(true);
                productVM.setPriceSale(df.format(setPriceVM(product)));
            }else {
                productVM.setHasSale(false);
            }
            productVMs.add(productVM);
        }

        /*set CartVM*/
        CartVM cartVM = setCartVM(guid);

        /**
         * set vm
         */


        vm.setProductVMs(productVMs);

        model.addAttribute("cartVM",cartVM);
        model.addAttribute("vm", vm);
        model.addAttribute("page", productPage);


        return "/grid";
    }

}
