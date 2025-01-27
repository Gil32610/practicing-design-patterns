package recipes;

import visitors.RecipeVisitor;

public interface RecipeComponent {
    public void addIngredient(RecipeComponent component);
    public abstract void accept(RecipeVisitor visitor);
}
