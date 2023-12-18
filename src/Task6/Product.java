package Task6;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
public class Product {
    private int id;
    private String type;
    private double price;
    private boolean discount;
    private LocalDate addingDate;


    public static void groupProductsByType(List<Product> products) {
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));
        groupedProducts.forEach((type, productListByType) -> {
            System.out.println(type + ":");
            productListByType.forEach(System.out::println);
        });
    }

}
