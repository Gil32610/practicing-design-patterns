package recipes;

import visitors.RecipeVisitor;

public class IngredientLeaf implements RecipeComponent {
    private Product product;
    private double ingredientQuantity;

    public IngredientLeaf(Product product, double ingredientQuantity) {
        this.product = product;
        this.ingredientQuantity = ingredientQuantity;
    }

    @Override
    public void addIngredient(RecipeComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(RecipeVisitor visitor) {
        visitor.visit(this);
    }

    public Product getProduct() {
        return product;
    }

    public double getIngredientQuantity() {
        return ingredientQuantity;
    }

    

}
