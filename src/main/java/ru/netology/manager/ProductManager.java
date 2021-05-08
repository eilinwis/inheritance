package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Smartphone;

public class ProductManager {
private ProductRepository repository;

public ProductManager(ProductRepository repository){
    this.repository = repository;
    }
    public void add(Product item){
    repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] found = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[found.length + 1];
                System.arraycopy(found, 0, tmp, 0, found.length);
                tmp[tmp.length - 1] = product;
                found = tmp;
            }
        }
        return found;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book){
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone){
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }
}
