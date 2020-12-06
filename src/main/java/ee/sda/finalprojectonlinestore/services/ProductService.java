package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Product;
import ee.sda.finalprojectonlinestore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    public Product getProductById(String id) {
        return productRepository.findById(Long.valueOf(id)).get();
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(Long.valueOf(id));
    }
}
