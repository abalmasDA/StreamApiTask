package Task1;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Product {
    private String type;
    private double price;


    public static List<Product> getBooksByCategory(List<Product> products) {
        return products.stream().filter(Product -> Product.getType().equals("Book") && Product.getPrice() > 250)
                .collect(Collectors.toList());
    }


}
