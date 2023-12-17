package leetcode.system_implementations.java_solutions;

import java.util.*;

public class DesignFoodRatingSystem_2353 {

    /**
     * Your FoodRatings object will be instantiated and called as such:
     * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
     * obj.changeRating(food,newRating);
     * String param_2 = obj.highestRated(cuisine);
     */

    static class FoodRatings {

        private final Map<String, Integer> foodToRating;
        private final Map<String, String> foodToCuisine;
        private final Map<String, TreeMap<Integer, Queue<String>>> cuisineFoodRating;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodToRating = new HashMap<>();
            foodToCuisine = new HashMap<>();
            cuisineFoodRating = new HashMap<>();

            for (int i = 0; i < foods.length; i++) {
                foodToCuisine.put(foods[i], cuisines[i]);
                foodToRating.put(foods[i], ratings[i]);
                cuisineFoodRating.putIfAbsent(cuisines[i], new TreeMap<>());
                cuisineFoodRating.get(cuisines[i]).putIfAbsent(ratings[i], new PriorityQueue<>());
                cuisineFoodRating.get(cuisines[i]).get(ratings[i]).offer(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            Integer oldRating = foodToRating.remove(food);
            foodToRating.put(food, newRating);
            TreeMap<Integer, Queue<String>> ratingToProductPerCuisine = cuisineFoodRating.get(foodToCuisine.get(food));
            Queue<String> foodNames = ratingToProductPerCuisine.get(oldRating);
            if (foodNames != null) {
                foodNames.remove(food);
                if (foodNames.isEmpty()) {
                    ratingToProductPerCuisine.remove(oldRating);
                }
            }
            ratingToProductPerCuisine.putIfAbsent(newRating, new PriorityQueue<>());
            ratingToProductPerCuisine.get(newRating).offer(food);
        }

        public String highestRated(String cuisine) {
            return cuisineFoodRating.get(cuisine).lastEntry().getValue().peek();
        }
    }
}
