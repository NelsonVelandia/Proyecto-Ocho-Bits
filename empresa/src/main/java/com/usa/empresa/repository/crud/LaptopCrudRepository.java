
package com.usa.empresa.repository.crud;

import com.usa.empresa.entity.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author NELSON
 */
public interface LaptopCrudRepository extends MongoRepository <Laptop, Integer> {

}
