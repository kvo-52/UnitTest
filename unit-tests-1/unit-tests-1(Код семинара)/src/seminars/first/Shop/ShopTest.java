package seminars.first.Shop;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {
    public static void main(String[] args) {
        // валидный экземпляр Магазина для проверки всех тестов
        Shop validShop = new Shop();
        validShop.setProducts(Arrays.asList(
                new Product(10, "Milk"),
                new Product(1, "Ages"),
                new Product(20, "Chicken")
        ));

        // Невалидный магазин с пустым списком продуктов (size = 0)
        Shop notValidShopProductsEmpty = new Shop();
        notValidShopProductsEmpty.setProducts(Arrays.asList());
        // Невалидный магазин с отсутствующим списком продуктов (null)
        Shop notValidShopProductsNull = new Shop();

        // Не знаю правильно ли я понял про тест на проверку верного списка продуктов
        // но других идей у меня нет
        assertThat(validShop.getProducts()).contains(
                new Product(1, "Ages"),
                new Product(10, "Milk"),
                new Product(20, "Chicken")
        );
        assertThat(notValidShopProductsEmpty.getProducts()).isEmpty();
        assertThat(notValidShopProductsNull.getProducts()).isNull();

        // тесты на проверку самого дорогого товара
        assertThat(validShop.getMostExpensiveProduct().getCost()).isEqualTo(20);
        assertThat(notValidShopProductsEmpty.getMostExpensiveProduct()).isNull();
        assertThat(notValidShopProductsNull.getMostExpensiveProduct()).isNull();

        // тесты на проверку сортировки продуктов
        assertThat(validShop.sortProductsByPrice()).isEqualTo(Arrays.asList(
                new Product(1, "Ages"),
                new Product(10, "Milk"),
                new Product(20, "Chicken")
        ));
        assertThat(notValidShopProductsEmpty.sortProductsByPrice()).isNull();
        assertThat(notValidShopProductsNull.sortProductsByPrice()).isNull();
    }
}