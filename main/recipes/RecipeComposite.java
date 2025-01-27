package recipes;

import java.util.ArrayList;
import java.util.List;

import br.unicap.eng2.atividade03.visitors.RecipeVisitor;

public class RecipeComposite implements RecipeComponent {
    private List<RecipeComponent> children;
    private double quantity;
    private String recipeName;

    public RecipeComposite(String recipeName, double quantity) {
        this.quantity = quantity;
        this.recipeName = recipeName;
        this.children = new ArrayList<>();
    }

    @Override
    public void addIngredient(RecipeComponent component) {
        this.children.add(component);
    }

    @Override
    public void accept(RecipeVisitor visitor) {
        visitor.visit(this);
    }

    public List<RecipeComponent> getChildren() {
        return children;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getRecipeName() {
        return recipeName;
    }

    

}
