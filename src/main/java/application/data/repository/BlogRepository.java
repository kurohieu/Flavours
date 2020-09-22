package application.data.repository;

import application.data.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository  extends JpaRepository <Blog, Integer> {

    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);


}
