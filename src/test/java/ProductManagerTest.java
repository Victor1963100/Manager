import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowling");

        manager.add(book1);

        Product[] actual = manager.findAll();
        Product[] expected = { book1 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchWhenFewProductsFindedTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "RTolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = { book1, book2 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AddSmartphoneTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smart1 = new Smartphone(1, "Samsung", 5000);

        manager.add(smart1);

        Product[] actual = manager.findAll();
        Product[] expected = { smart1 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchWhenFewSmartphonesFindedTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smart1 = new Smartphone(1, "Samsung", 5000);
        Smartphone smart2 = new Smartphone(2, "Huaway", 4500);
        Smartphone smart3 = new Smartphone(3, "Xiaomy", 5500);

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = manager.searchBy("Huaway");
        Product[] expected = { smart2 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveByIdBookTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "RTolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.removeById(2);

        Product[] actual = manager.findAll();
        Product[] expected = { book1, book3 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveBySmartphoneTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smart1 = new Smartphone(1, "Samsung", 5000);
        Smartphone smart2 = new Smartphone(2, "Huaway", 4500);
        Smartphone smart3 = new Smartphone(3, "Xiaomy", 5500);

        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        manager.removeById(1);

        Product[] actual = manager.findAll();
        Product[] expected = { smart2, smart3 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveAllBooksTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "RTolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.removeById(1);
        manager.removeById(2);
        manager.removeById(3);

        Product[] actual = manager.findAll();
        Product[] expected = {  };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ProductPriceTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Harry Potter 1", 300, "Rowling");

        manager.add(book1);

        int expectedPrice = 300;
        int actualPrice = book1.getPrice();

        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void ProductBookIdTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");

        manager.add(book2);

        int expectedId = 2;
        int actualId = book2.getId();

        Assertions.assertEquals(expectedId, actualId);
    }
}
