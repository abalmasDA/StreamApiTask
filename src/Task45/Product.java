package Task45;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Product {

    private String type;
    private double price;
    private boolean discount;
    private LocalDate addingDate;


    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddingDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


    public static double getTotalCostProductsByParameters(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getAddingDate().getYear() == Year.now().getValue())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }


}
