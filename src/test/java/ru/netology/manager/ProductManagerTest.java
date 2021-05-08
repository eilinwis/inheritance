package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;
import ru.netology.domain.Smartphone;



class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book("Стрелок", 250, 1, "С.Кинг");
    private Book secondBook = new Book("Извлечение троих", 280, 2, "С.Кинг");
    private Book thirdBook = new Book("Бесплодные земли", 280, 3, "С.Кинг");
    private Book fourthBook = new Book("Колдун и кристал", 300, 4, "С.Кинг");
    private Book fifthBook = new Book("Волки Кальи", 410, 5, "С.Кинг");
    private Book sixthBook = new Book("Песнь Сюзанны", 260, 6, "С.Кинг");
    private Book seventhBook = new Book("Темная башня", 420, 7, "С.Кинг");
    private Smartphone firstSmartphone = new Smartphone("Iphone 10", 80000, 8, "Apple");
    private Smartphone secondSmartphone = new Smartphone("Galaxy A11", 180000, 9, "Samsung");
    private Smartphone thirdSmartphone = new Smartphone("Iphone 12", 280000, 10, "Apple");

    @BeforeEach
    public void shouldAdd() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);
        manager.add(sixthBook);
        manager.add(seventhBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
    }

    @Test
    void searchByName() {
        Product[] actual = manager.searchBy("темная башня");
        Product[] expected = new Product[]{seventhBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        Product[] actual = manager.searchBy("С.Кинг");
        Product[] expected = new Product[]{firstBook, secondBook, thirdBook, fourthBook, fifthBook, sixthBook, seventhBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProducer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{firstSmartphone, thirdSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByPhonename() {
        Product[] actual = manager.searchBy("Galaxy A11");
        Product[] expected = new Product[]{secondSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNonExisting() {
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNonExistingBook() {
        Product[] actual = manager.searchBy("А. Конан Дойл");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);

    }
}