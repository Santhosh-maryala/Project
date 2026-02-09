
import java.util.ArrayList;

class Product{
    String name;
    double price;

     Product(String name,double price) {
        this.name=name;
        this.price=price;
        }
        void displayProduct(){
            System.out.println("Product : " + name +" Price : $" + price);
        }   
}

public class ShoppingCart{
    public static void main(String[] args) {
        ArrayList <Product> cart =new ArrayList<>();

        cart.add(new Product("Mobile", 39999.90));
        cart.add(new Product("Laptop",549999.89));
        cart.add(new Product("TV",59859.0));
        
        System.out.println("Shopping Cart Contents:");
        for(Product product : cart){
            product.displayProduct();
        }
        double totalBill =0;
        for(Product product: cart){
            totalBill+= product.price;
        }
        System.out.println("Total Bill Amount : $"+ totalBill);
    }     
}