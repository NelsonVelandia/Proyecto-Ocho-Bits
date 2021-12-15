package com.usa.empresa.controller;

import com.usa.empresa.entity.User;
import com.usa.empresa.services.UserService;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    /**
     * Variable de clase UserService.
     */
    @Autowired
    private UserService userService;

    /**
     * Lista todos los usuarios registrados.
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /**
     * Devuelve un usuario pasando por parametro el Id.
     *
     * @param idUser
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getIdUser(@PathVariable("id") int idUser) {
        return userService.getIdUser(idUser);
    }

    /**
     * Registrar un nuevo usuario.
     *
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Actualiza el nombre del usuario.
     *
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Borrar un usuario.
     *
     * @param idUs
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int idUs) {
        return userService.deleteUser(idUs);
    }

    /**
     * Autentica el password y el email.
     *
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    /**
     * Verifica si existe un email.
     *
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
    
    /**
     * Cumpleaños del mes.
     * @param month
     * @return 
     */
    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){
        return userService.listBirthtDayMonth(month);
    }
}
