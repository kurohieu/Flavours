package application.data.service;

import application.data.model.Blog;
import application.data.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BlogService {


    @Autowired
    private BlogRepository blogRepository;

//    @Transactional(readOnly = true)
//    public List<Blog> getAllBlogs(final int count){
//        return this.blogRepository.findAll().stream().limit(count).collect(Collectors.toList());
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<Blog> getBlog(final int id){return this.blogRepository.findById(id);}

    @Transactional
    public void addNewListBlogs(List<Blog> blog) {
        blogRepository.save(blog);
    }

    public Blog findOne(int blogId) {
        return blogRepository.findOne(blogId);
    }

    public void addNewBlog(Blog blog) {

        blogRepository.save(blog);
    }


    public boolean updateSale(Blog blog) {
        try {
            blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBlog(int blogId) {
        try {
            blogRepository.delete(blogId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Blog> getListAllBlogs() {
        try {
            return blogRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

