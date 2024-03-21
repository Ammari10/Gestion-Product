package ma.achraf.university.repository;

import ma.achraf.university.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {
 List<Product> findByNameContains (String mc);
  List<Product> findByPriceGreaterThan(double price);
}
