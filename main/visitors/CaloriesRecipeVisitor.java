package visitors;

import java.util.List;

import recipes.IngredientLeaf;
import recipes.RecipeComponent;
import recipes.RecipeComposite;

public class CaloriesRecipeVisitor implements RecipeVisitor {
    private double calories;

    public CaloriesRecipeVisitor() {
        this.calories = 0.0;
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        List<RecipeComponent> children = recipeComposite.getChildren();
        for (RecipeComponent child : children) {
            for (int i = 0; i < recipeComposite.getQuantity(); i++) {
                child.accept(this);
            }
        }
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        double ingredientCalories = ingredientLeaf.getIngredientQuantity() * ingredientLeaf.getProduct().getCalories();
        this.calories += ingredientCalories;
    }

    public double getCalories() {
        return calories;
    }

}
