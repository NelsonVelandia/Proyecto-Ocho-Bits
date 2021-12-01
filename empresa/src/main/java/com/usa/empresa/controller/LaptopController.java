package com.usa.empresa.controller;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.services.LaptopService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NELSON
 */
@RestController
@RequestMapping("/api/laptop")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LaptopController {

    /**
     * Variable de clase LaptopService.
     */
    @Autowired
    private LaptopService laptopService;

    /**
     * Lista todos los productos registrados.
     *
     * @return
     */
    @GetMapping("/all")
    public List<Laptop> getAllLaptop() {
        return laptopService.getAllLaptop();
    }

    /**
     * Devuelve un producto pasando por parametro el Id.
     *
     * @param idLaptop
     * @return
     */
    @GetMapping("/={id}")
    public Optional<Laptop> getIdLaptop(@PathVariable("id") int idLaptop) {
        return laptopService.getIdLaptop(idLaptop);
    }

    /**
     * Registrar un nuevo producto.
     *
     * @param laptop
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop save(@RequestBody Laptop laptop) {
        return laptopService.save(laptop);
    }

    /**
     * Actualiza los atributos del producto.
     *
     * @param laptop
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop) {
        return laptopService.update(laptop);
    }

    /**
     * Borrar un producto.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteLaptop(@PathVariable("id") int id) {
        return laptopService.deleteLaptop(id);
    }

}
