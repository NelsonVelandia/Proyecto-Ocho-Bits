package com.usa.empresa.repository;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.repository.crud.LaptopCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NELSON
 */
@Repository
public class LaptopRepository {

    @Autowired
    private LaptopCrudRepository laptopCrudRepository;

    public List<Laptop> getAllLaptop() {
        return (List<Laptop>) laptopCrudRepository.findAll();
    }

    public Optional<Laptop> getIdLaptop(int id) {
        return laptopCrudRepository.findById(id);
    }

    public Laptop save(Laptop laptop) {
        return laptopCrudRepository.save(laptop);
    }

    public void delete(Laptop laptop) {
        laptopCrudRepository.delete(laptop);
    }

}
