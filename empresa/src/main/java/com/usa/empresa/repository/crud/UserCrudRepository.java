package com.usa.empresa.repository.crud;

import com.usa.empresa.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author NELSON
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    //Optional<User> findByName(String name);
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();

    //Listado de cumpleaños del mes
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
