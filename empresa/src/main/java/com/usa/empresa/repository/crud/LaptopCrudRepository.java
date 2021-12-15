package com.usa.empresa.repository.crud;

import com.usa.empresa.entity.Laptop;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author NELSON
 */
public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {

    Optional<Laptop> findTopByOrderByIdDesc();
    
    public List<Laptop> findByPriceLessThanEqual(double price);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Laptop> findByDescriptionLike(String description);
}
