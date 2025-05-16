package org.example.downstream;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static org.example.downstream.PriceController.LOGGER;

@Repository
public class PriceRepository {

    private Map<Long,Price> priceMap=new HashMap<>();

    public PriceRepository() {
        priceMap.put(51L,new Price(51L,25.2,614));
        priceMap.put(52L,new Price(52L,37,614));
    }

    public Price getPrice(Long productId){
        LOGGER.info("Getting Price from Price Repo With Product Id {}", productId);
        if (!priceMap.containsKey(productId)){
            LOGGER.error("Price Not Found for Product Id {}", productId);
            throw new PriceNotFoundException("Price Not Found");
        }
        return priceMap.get(productId);
    }
}
