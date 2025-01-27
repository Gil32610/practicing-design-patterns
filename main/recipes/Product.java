package recipes;

public class Product {
    private String productName;
    private double calories;

    public Product(String productName, double calories) {
        this.productName = productName;
        this.calories = calories;
    }

    public double  getCalories(){
        return this.calories;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Product){
            Product compareProduct = (Product) obj;
            return this.calories == compareProduct.getCalories() && this.productName.equals(compareProduct.getProductName());
        }return false;
    }

    

    

    
}
