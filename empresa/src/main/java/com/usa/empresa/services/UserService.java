package com.usa.empresa.services;

import com.usa.empresa.entity.User;
import com.usa.empresa.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NELSON
 */
@Service
public class UserService {

    /**
     * Variable de clase UserRepository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Listar todos los Usuarios.
     * @return 
     */
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
    
    /**
     * Traer un Usuario por Id si existe.
     * @param idUser
     * @return 
     */
    public Optional<User> getIdUser(int idUser) {
        return userRepository.getIdUser(idUser);
    }

    /**
     * Guardar
     * @param user
     * @return 
     */
    
    public User save1(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> usa = userRepository.getIdUser(user.getId());
            if (usa.isPresent()) {
                return user;
            }
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        }
    }

    /**
     * Guardar
     * @param user
     * @return 
     */
    public User save(User user) {

        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();

        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (!userIdMaximo.isPresent()) {
                user.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }

        Optional<User> exs = userRepository.getIdUser(user.getId());
        if (!exs.isPresent()) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    /**
     * Verificar email.
     * @param email
     * @return 
     */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    /**
     * Autenticar
     * @param email
     * @param password
     * @return 
     */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            return new User();
        }
    }

    /**
     * Actualizar
     * @param user
     * @return 
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> cli = userRepository.getIdUser(user.getId());
            if (cli.isPresent()) {
                if (user.getName() != null) {
                    cli.get().setName(user.getName());
                }
                if (user.getEmail() != null) {
                    cli.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    cli.get().setPassword(user.getPassword());
                }
                if (user.getIdentification() != null) {
                    cli.get().setIdentification(user.getIdentification());
                }
                if (user.getAddress() != null) {
                    cli.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    cli.get().setCellPhone(user.getCellPhone());
                }
                if (user.getZone() != null) {
                    cli.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    cli.get().setType(user.getType());
                }

                return userRepository.save(cli.get());
            }
        }
        return user;
    }

    /**
     * Eliminar
     * @param idUs
     * @return 
     */
    public boolean deleteUser(int idUs) {
        Optional<User> cli = getIdUser(idUs);
        if (cli.isPresent()) {
            userRepository.delete(cli.get());
            return true;
        }
        return false;
    }
    
    /**
     * Retorna los cumpleaños del mes.
     * @param month
     * @return 
     */
    public List<User> listBirthtDayMonth(String month){
        return userRepository.listBirthtDayMonth(month);
    }
}
