package org.example.downstream;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static org.example.downstream.ProductController.LOGGER;

@Repository
public class ProductRepository {
    private Map<Long, Product> productMap = new HashMap<>();
    private final PriceRepository priceRepository;

    public ProductRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
        productMap.put(51L, new Product(51L, "pofac", priceRepository.getPrice(51L)));
        productMap.put(52L, new Product(52L, "chips", priceRepository.getPrice(52L)));
    }

    public Product getProduct(Long productId) {
        LOGGER.info("Getting Product from Product Repo With Product Id {}", productId);
        if (!productMap.containsKey(productId)) {
            LOGGER.error("Product Not Found for Product Id {}", productId);
            throw new ProductNotFoundException("Product Not Found");
        }
        return productMap.get(productId);
    }
}
