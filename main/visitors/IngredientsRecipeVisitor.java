package visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import recipes.IngredientLeaf;
import recipes.RecipeComponent;
import recipes.RecipeComposite;

public class IngredientsRecipeVisitor implements RecipeVisitor {
    private List<String> ingredients;
    private List<String> path;

    public IngredientsRecipeVisitor() {
        this.ingredients = new ArrayList<>();
        path = new ArrayList<>();
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        List<RecipeComponent> children = recipeComposite.getChildren();

        String compositeName = recipeComposite.getRecipeName();
        path.add(compositeName);
        for (RecipeComponent child : children) {
            child.accept(this);
        }
        path.remove(compositeName);
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        String productName = ingredientLeaf.getProduct().getProductName();
        this.path.add(productName);
        addIngredientToList();
        this.path.remove(productName);
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    private void addIngredientToList() {
        StringBuilder sbComponent = new StringBuilder();
        String componentSeparator = ", ";
        int pathSize = path.size();
        for (int i = 0; i < pathSize - 1; i++) {
            sbComponent.append(path.get(i));
            sbComponent.append(componentSeparator);
        }
        sbComponent.append(path.get(pathSize - 1));
        ingredients.add(sbComponent.toString());
    }

}
