package com.usa.empresa.services;

import com.usa.empresa.entity.Laptop;
import com.usa.empresa.repository.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NELSON
 */
@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptop() {
        return laptopRepository.getAllLaptop();
    }

    public Optional<Laptop> getIdLaptop(int idLaptop) {
        return laptopRepository.getIdLaptop(idLaptop);
    }

    public Laptop save1(Laptop laptop) {

        if (laptop.getId() == null) {
            return laptop;
        } else {
            Optional<Laptop> lap = laptopRepository.getIdLaptop(laptop.getId());
            if (lap.isPresent()) {
                return laptop;
            }
        }
        return laptopRepository.save(laptop);
    }
    
    public Laptop save(Laptop laptop) {

        //obtiene el maximo id existente en la coleccion
        Optional<Laptop> laptopIdMaxima = laptopRepository.lastUserId();

        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (laptop.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (!laptopIdMaxima.isPresent()) {
                laptop.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else {
                laptop.setId(laptopIdMaxima.get().getId() + 1);
            }
        }

        Optional<Laptop> exs = laptopRepository.getIdLaptop(laptop.getId());
        if (!exs.isPresent()) {
            return laptopRepository.save(laptop);
        } else {
            return laptop;
        }
    }

    public Laptop update(Laptop laptop) {
        if (laptop.getId() != null) {
            Optional<Laptop> cli = laptopRepository.getIdLaptop(laptop.getId());
            if (cli.isPresent()) {
                if (laptop.getBrand() != null) {
                    cli.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    cli.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    cli.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    cli.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    cli.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    cli.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    cli.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getPrice() > 0) {
                    cli.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() >= 0) {
                    cli.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    cli.get().setPhotography(laptop.getPhotography());
                }
                cli.get().setAvailability(laptop.isAvailability());
                laptopRepository.save(cli.get());
                
                return laptopRepository.save(cli.get());
            }
        }
        return laptop;
    }

    public boolean deleteLaptop(int idL) {
        Optional<Laptop> cli = getIdLaptop(idL);
        if (cli.isPresent()) {
            laptopRepository.delete(cli.get());
            return true;
        }
        return false;
    }
}
