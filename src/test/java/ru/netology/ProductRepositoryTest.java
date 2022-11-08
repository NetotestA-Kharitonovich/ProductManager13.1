package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.Smartphone;

import static org.junit.jupiter.api.Assertions.*;
public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book = new Book(101, "iPhone,инструкция для пользователя", 500, "Борисов В.В.");
    Product smartphone = new Smartphone(201, "iPhone 14 Pro Max", 115000, "Apple Inc.");
    Product product = new Product(301, "Кетчуп", 150);
    @Test
    public void shouldSaveOneItem() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAll() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = { book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(201);
        Product[] expected = { book, product };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveAllById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(101);
        repository.removeById(201);
        repository.removeById(301);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}