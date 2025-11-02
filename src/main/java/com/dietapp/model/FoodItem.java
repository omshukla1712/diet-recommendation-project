package com.dietapp.model;

    public class FoodItem {
        private Integer id;
        private String name;
        private Float caloriesPer100g;
        private Float protein;
        private Float carbs;
        private Float fats;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getCaloriesPer100g() {
            return caloriesPer100g;
        }

        public void setCaloriesPer100g(Float caloriesPer100g) {
            this.caloriesPer100g = caloriesPer100g;
        }

        public Float getProtein() {
            return protein;
        }

        public void setProtein(Float protein) {
            this.protein = protein;
        }

        public Float getCarbs() {
            return carbs;
        }

        public void setCarbs(Float carbs) {
            this.carbs = carbs;
        }

        public Float getFats() {
            return fats;
        }

        public void setFats(Float fats) {
            this.fats = fats;
        }

        public FoodItem(Float fats, Float carbs, Float protein, Float caloriesPer100g, String name, Integer id) {
            this.fats = fats;
            this.carbs = carbs;
            this.protein = protein;
            this.caloriesPer100g = caloriesPer100g;
            this.name = name;
            this.id = id;
        }
        public FoodItem() {}
    }
