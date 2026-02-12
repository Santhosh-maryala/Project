import java.util.ArrayList;
import java.util.List;

interface Product {
    String getName();
    double getPrice();
}

class Electronics implements Product {
    private final String name;
    private final double price;

    public Electronics(String name, double price)
     {
        this.name = name; 
        this.price = price; 
        }
    @Override 
    public String getName() 
    { return name; 
    }
    @Override 
    public double getPrice()
     { 
        return price; 
        }
}

class Clothing implements Product {
    private final String name;
    private final double price;

    public Clothing(String name, double price) {
         this.name = name; 
         this.price = price; 
         }
    @Override 
    public String getName() 
    {
         return name;
     }
    @Override 
    public double getPrice()
     { 
        return price;
        }
}

class Groceries implements Product {
    private final String name;
    private final double price;

    public Groceries(String name, double price) 
    { 
        this.name = name; 
        this.price = price; 
        }
    @Override public String getName() 
    { return name;
     }
    @Override public double getPrice()
     { return price;
      }
}

interface DiscountStrategy {
    double applyDiscount(double total);
}

class PercentageDiscount implements DiscountStrategy {
    private final double percentage;
    public PercentageDiscount(double percentage)
     { 
        this.percentage = percentage; 
        }
    @Override public double applyDiscount(double total)
     { 
        return total - (total * (percentage / 100));
         }
}

class FlatDiscount implements DiscountStrategy {
    private final double discountAmount;
    public FlatDiscount(double discountAmount) { 
        this.discountAmount = discountAmount; 
        }
    @Override
     public double applyDiscount(double total) {
         return total - discountAmount;
        }
}

class ShoppingCart {
    private final List<Product> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(Product product) 
    { 
        products.add(product); 
    }
    public void setDiscountStrategy(DiscountStrategy strategy){ 
        this.discountStrategy = strategy;
         }

    public double calculateTotal() {
        double subtotal = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        if (discountStrategy != null) {
            return discountStrategy.applyDiscount(subtotal);
        }
        return subtotal;
    }
}

public class ECommerceCartSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Electronics("Laptop", 1000.0));
        cart.addProduct(new Clothing("Shirt", 50.0));
        cart.addProduct(new Groceries("Apples", 10.0));

        cart.setDiscountStrategy(new PercentageDiscount(10));
        System.out.println("Total (10% Off): $" + cart.calculateTotal()); 

        cart.setDiscountStrategy(new FlatDiscount(50));
        System.out.println("Total ($50 Off): $" + cart.calculateTotal()); 
    }
}
