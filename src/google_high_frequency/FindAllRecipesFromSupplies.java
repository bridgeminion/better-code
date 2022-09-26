package google_high_frequency;

import java.util.*;

public class FindAllRecipesFromSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> recipeSet = new HashSet<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            recipeSet.add(recipe);
            List<String> ingredientOfRecipe = ingredients.get(i);

            for (String ingredient : ingredientOfRecipe) {
                adjList.computeIfAbsent(ingredient, x -> new ArrayList<>()).add(recipe);
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (String supply : supplies) queue.add(supply);

        while (!queue.isEmpty()) {
            String curr = queue.removeFirst();
            if (recipeSet.contains(curr)) result.add(curr);

            if (adjList.containsKey(curr)) {
                for (String neighbor : adjList.get(curr)) {
                    int newOccurrence = indegree.get(neighbor) - 1;
                    indegree.put(neighbor, newOccurrence);
                    if (newOccurrence == 0) queue.add(neighbor);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        FindAllRecipesFromSupplies app = new FindAllRecipesFromSupplies();
        String[] recipes = {"bread","sandwich"};
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast","flour"), Arrays.asList("bread","meat"));
        String[] supplies = {"yeast","flour","meat"};
        app.findAllRecipes(recipes, ingredients, supplies);
    }
}
