package application.controller.web;


import application.model.viewmodel.common.ProductVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(path = "/blog")
public class BlogController  extends  BaseController{
    private static final Logger logger = LogManager.getLogger(BlogController.class);
//    final
//    private BlogRepository blogRepository;
//
//    public BlogController(BlogRepository blogRepository) {
//        this.blogRepository = blogRepository;
//    }
//
//    @Operation(summary = "Find all blogs", description = "All blogs", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Blog.class)))) })
//    @GetMapping("/blog")
//    public List<Blog> index(){
//        return blogRepository.findAll();
//    }
//
//
//
//    @Operation(summary = "Find blog by id", description = "Find blog by id", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation = Blog.class))) })
//    @GetMapping("/blog/{id}")
//    public Blog show(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        return blogRepository.findById(blogId).orElse(new Blog());
//    }
//
//    @PostMapping("/blog/search")
//    @Operation(summary = "search blog by text in title", description = "Find blog by text in title", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Blog.class)))) })
//    public List<Blog> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }
//
//
//    @Operation(summary = "Create a new blog", description = "Create a new blog", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation = Blog.class))) })
//    @PostMapping("/blog")
//    public Blog create(@RequestBody Map<String, String> body){
//        String title = body.get("title");
//        String content = body.get("content");
//        return blogRepository.save(new Blog(title, content));
//    }
//
//
//    @Operation(summary = "Update a new blog", description = "Update a new blog", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation = Blog.class))) })
//    @PutMapping("/blog/{id}")
//    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int blogId = Integer.parseInt(id);
//        // getting blog
//        Blog blog = blogRepository.findById(blogId).orElse(new Blog());
//        blog.setTitle(body.get("title"));
//        blog.setContent(body.get("content"));
//        return blogRepository.save(blog);
//    }
//
//
//    @Operation(summary = "Delete a  blog", description = "Delete a blog", tags = { "blog" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation =  Boolean.class))) })
//    @DeleteMapping("blog/{id}")
//    public boolean delete(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        blogRepository.deleteById(blogId);
//        return true;
//    }
//
//}
@GetMapping("/{blogId}")
public String blog(@PathVariable Integer blogId, Model model,
                   @Valid @ModelAttribute("productname") ProductVM productName,
                            HttpServletResponse response,
                            HttpServletRequest request,
                            final Principal principal) {

    this.checkCookie(response, request, principal);

//        model.addAttribute("page", page);
//        log.info("SId: {}", httpSession.getAttribute("TOI_LA_USE"));
//        return "pages/page";
//    }
//
//    @PostMapping(value = "/create")
//    public String savePage(
//            @Valid @ModelAttribute(value="page") Pages page,
//            BindingResult bindingResult, Model model) {
//
//        String VIEW_FILE = "pages/page";
//        log.info("page name: {}, content: {}", page.getName(), page.getContent());
//
//        if (bindingResult.hasErrors()) {
//            return VIEW_FILE;
//        }
//
//        try {
//            String image = BaseUploads.uploadSignFile(page.getImgPresedent(), page);
//            page.setImage(image);
//        } catch (Exception e) {
//            ObjectError error = new ObjectError("file-error", e.getMessage());
//            bindingResult.addError(error);
//        }
//
//        pagesDao.persist(page);
//        return VIEW_FILE;
//    }



    return "/blog";
}


}