//package application.controller.web;
//
//
//import application.data.model.Category;
//import application.data.model.Product;
//import application.data.service.CartService;
//import application.data.service.CategoryService;
//import application.data.service.ProductService;
//import application.model.viewmodel.admin.AdminCategoryVM;
//import application.model.viewmodel.admin.AdminProductVM;
//import application.model.viewmodel.admin.HomeAdminVM;
//import application.model.viewmodel.common.CategoryVM;
//import application.model.viewmodel.common.ProductVM;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.security.Principal;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class AdminController {
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private CartService cartService;
//
//    @GetMapping("")
//    public String admin(Model model,
//                        @Valid @ModelAttribute("product") ProductVM productName,
//                        @RequestParam(name = "categoryId", required = false) Integer categoryId,
//                        @RequestParam(name = "priceMin",required = false) Double priceMin,
//                        @RequestParam(name = "priceMax",required = false) Double priceMax,
//                        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                        @RequestParam(name = "size", required = false, defaultValue = "12") Integer size,
//                        @RequestParam(name = "sortByPrice", required = false) String sort,
//                        HttpServletResponse response,
//                        HttpServletRequest request,
//                        final Principal principal) {
//
//        HomeAdminVM vm = new HomeAdminVM();
//        model.addAttribute("vm",vm);
//        return "/admin/home";
//    }
//
//
//    @GetMapping("/product")
//    public String product(Model model,
//                          @Valid @ModelAttribute("product") ProductVM productForm,
//                          @RequestParam(name = "categoryId", required = false) Integer categoryId,
//                          @RequestParam(name = "priceMin",required = false) Double priceMin,
//                          @RequestParam(name = "priceMax",required = false) Double priceMax,
//                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                          @RequestParam(name = "sortByPrice", required = false) String sort,
//                          HttpServletResponse response,
//                          HttpServletRequest request,
//                          final Principal principal) {
//
//        AdminProductVM vm = new AdminProductVM();
//        DecimalFormat df = new DecimalFormat("##,###,###");
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//        /**
//         * set list categoryVM
//         */
//
//        List<Category> categorys = categoryService.getListAllCategories();
//        List<CategoryVM> categoryVMs = new ArrayList<>();
//
//        for (Category category : categorys) {
//            CategoryVM categoryVM = new CategoryVM();
//            categoryVM.setId(category.getId());
//            categoryVM.setName(category.getName());
//            categoryVMs.add(categoryVM);
//        }
//
//        /**
//         * set list productVM
//         */
//
//        Sort sortable = new Sort(Sort.Direction.ASC,"id");
//        if(sort != null) {
//            if (sort.equals("ASC")) {
//                sortable = new Sort(Sort.Direction.ASC,"price");
//            }else {
//                sortable = new Sort(Sort.Direction.DESC,"price");
//            }
//        }
//
//        Pageable pageable = new PageRequest(page, size, sortable);
//        Page<Product> productPage;
//
//        if(categoryId != null) {
//            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable,categoryId,null,null, null);
//            Category category = categoryService.findOne(categoryId);
//            vm.setKeyWord(category.getName());
//        } else if (productName.getName() != null && !productName.getName().isEmpty()) {
//            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null,null,null,productName.getName().trim());
//            vm.setKeyWord("Find with key: " + productName.getName());
//        } else {
//            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null,null,null,null);
//        }
//
//        List<ProductVM> productVMList = new ArrayList<>();
//
//        for(Product product : productPage.getContent()) {
//            ProductVM productVM = new ProductVM();
//            productVM.setId(product.getId());
//            productVM.setName(product.getName());
//            productVM.setMainImage(product.getMainImage());
//            productVM.setPrice(df.format(product.getPrice()));
//            productVMList.add(productVM);
//        }
//
//
//
//        model.addAttribute("page", productPage);
//        model.addAttribute("vm",vm);
//        return "/admin/product";
//    }
//
//
//    @GetMapping("/category")
//    public String category(Model model,
//                           @Valid @ModelAttribute("category") CategoryVM categoryVM,
//                           HttpServletResponse response,
//                           HttpServletRequest request,
//                           final Principal principal) {
//
//        AdminCategoryVM vm = new AdminCategoryVM();
//        List<CategoryVM> categoryVMS = categoryService.getListAllCategories();
//        vm.setCategoryVMList(categoryVMS);
//
//        model.addAttribute("vm",vm);
//        return "/admin/category";
//    }
//
//
//}
//}
