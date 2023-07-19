import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "смартфон", 50_000);
        Product product2 = new Product(20, "альбом", 500);
        Product product3 = new Product(350, "дом", 15_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(20);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductExist1() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "смартфон", 50_000);
        Product product2 = new Product(20, "альбом", 500);
        Product product3 = new Product(350, "дом", 15_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(50)
        );
    }
}
