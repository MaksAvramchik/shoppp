package by.shop.shop.repository;

import by.shop.shop.entyty.Product;
import by.shop.shop.entyty.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findByProductType(ProductType productType);
}
