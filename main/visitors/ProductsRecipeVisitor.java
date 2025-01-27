package visitors;

import java.util.ArrayList;
import java.util.List;

import recipes.IngredientLeaf;
import recipes.Product;
import recipes.RecipeComponent;
import recipes.RecipeComposite;

public class ProductsRecipeVisitor implements RecipeVisitor {
    private List<Product> products;

    public ProductsRecipeVisitor() {
        this.products = new ArrayList<>();
    }

    @Override
    public void visit(RecipeComposite recipeComposite) {
        List<RecipeComponent> children = recipeComposite.getChildren();
        for (RecipeComponent child : children) {
            child.accept(this);
        }
    }

    @Override
    public void visit(IngredientLeaf ingredientLeaf) {
        Product product = ingredientLeaf.getProduct();
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

}
