package visitors;

import recipes.IngredientLeaf;
import recipes.RecipeComposite;

public interface RecipeVisitor {
    public abstract void visit(RecipeComposite recipeComposite);
    public abstract void visit(IngredientLeaf ingredientLeaf);
}
