package com.dietapp.model;
import java.time.LocalDate;
public class UserDiet {

    private Integer id;

    private User user;

    private FoodItem foodItem;

    private Float quantityGrams;
    private String mealType;
    private LocalDate date;

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

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Float getQuantityGrams() {
        return quantityGrams;
    }

    public void setQuantityGrams(Float quantityGrams) {
        this.quantityGrams = quantityGrams;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserDiet(Integer id, User user, FoodItem foodItem, Float quantityGrams, String mealType, LocalDate date) {
        this.id = id;
        this.user = user;
        this.foodItem = foodItem;
        this.quantityGrams = quantityGrams;
        this.mealType = mealType;
        this.date = date;
    }
    public UserDiet() {}

}
