package com.dietapp.model;
import java.time.LocalDateTime;

public class Recommendation {

    private Integer id;

    private User user;

    private String recommendedFood;
    private Float calories;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecommendedFood() {
        return recommendedFood;
    }

    public void setRecommendedFood(String recommendedFood) {
        this.recommendedFood = recommendedFood;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Recommendation(Integer id, User user, String recommendedFood, Float calories, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.recommendedFood = recommendedFood;
        this.calories = calories;
        this.createdAt = createdAt;
    }
    public Recommendation() {}
}
