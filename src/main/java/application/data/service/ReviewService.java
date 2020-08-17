package application.data.service;


import application.data.model.Product;
import application.data.model.Review;
import application.data.repository.ReviewRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public void addNewListReviews(List<Review> reviews) {
        try {
            reviewRepository.save(reviews);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void addNewReview(Review review) {
        try{
            reviewRepository.save(review);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public Review findOne(int reviewId) {

        return reviewRepository.findOne(reviewId);
    }

    public boolean updateReview(Review review) {
        try {
            reviewRepository.save(review);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean deleteReview(int reviewId) {
        try {
            reviewRepository.delete(reviewId);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
    public List<Integer> getReviewByProduct(Product product){
        return reviewRepository.getRateByProduct(product);
    }
    public List<Integer> getStarByProductAndUserName(Product product, String userName){
        return reviewRepository.getStarByProductAndUserName(product,userName);
    }
    public Review findStarByProductAndUserName(Product product, String userName){
        return StreamSupport
                .stream(reviewRepository.findStarByProductAndUserName(product,userName).spliterator(), false)
                .findFirst().orElse(null);
    }

}