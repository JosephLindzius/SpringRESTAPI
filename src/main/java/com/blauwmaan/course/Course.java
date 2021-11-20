package com.blauwmaan.course;

import com.blauwmaan.core.BaseEntity;
import com.blauwmaan.review.Review;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity {
    @NotNull
    private String title;
    private String url;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course(){
       super();
       reviews = new ArrayList<>();
    }

    public Course(String title, String url){
        this();
        this.title = title;
        this.url = url;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviews.add(review);
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }


}
