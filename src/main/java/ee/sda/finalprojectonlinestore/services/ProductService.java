package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Product;
import ee.sda.finalprojectonlinestore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
