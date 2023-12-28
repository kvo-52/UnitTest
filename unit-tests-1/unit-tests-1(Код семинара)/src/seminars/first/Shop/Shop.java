package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Мы хотим улучшить функциональность нашего интернет-магазина.
 * Ваша задача - добавить два новых метода в класс Shop:
 * Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
 * Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
 * Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
 * (правильное количество продуктов, верное содержимое корзины).
 * Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
 * Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
 * Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */
public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     *
     * @return sortedList - отсортированная, по возрастанию цены, копия начального списка продуктов
     */
    public List<Product> sortProductsByPrice() {
        if (products == null || products.size() == 0) return null;

        List<Product> sortedList = new ArrayList<>(products);
//        sortedList.sort((o1, o2) -> o1.getCost() - o2.getCost());  //
        sortedList.sort(Comparator.comparingInt(Product::getCost));
        return sortedList;
    }

    /**
     *
     * @return Продукт с наибольшей стоимостью или null - если список продуктов равен null или пустой
     */
    public Product getMostExpensiveProduct() {
        if (products == null || products.size() == 0) return null;

        Product mostExpensiveProduct = new Product(0, "");
        for (Product product : products) {
            if (product.getCost() > mostExpensiveProduct.getCost()) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

}

