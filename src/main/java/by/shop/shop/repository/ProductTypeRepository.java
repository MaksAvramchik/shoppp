package by.shop.shop.repository;

import by.shop.shop.entyty.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
}
