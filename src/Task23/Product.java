package Task23;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class Product {
    private String type;
    private double price;
    private boolean discount;


    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(Product -> Product.getType().equals("Book") && Product.isDiscount())
                .peek(Product -> Product.setPrice(Product.getPrice() * 0.9))
                .collect(Collectors.toList());
    }


    public static void getCheapestBook(List<Product> products) {
        Product cheapestBook = products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product 'Book' not found"));

        System.out.println("Cheapest product: " + cheapestBook.getType() + ", Price: " + cheapestBook.getPrice());
    }
}
