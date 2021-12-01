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

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public Optional<User> getIdUser(int idUser) {
        return userRepository.getIdUser(idUser);
    }

    public User save(User user) {
        if (user.getId() == null) {
            return user;
        }else{
            Optional<User> usa = userRepository.getIdUser(user.getId());
            if(usa.isPresent()){
                return user;
            }
            if (existeEmail(user.getEmail()) == false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            return new User();
        }
    }

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

    public boolean deleteUser(int id) {
        Optional<User> cli = getIdUser(id);
        if (cli.isPresent()) {
            userRepository.delete(cli.get());
            return true;
        }
        return false;
    }
}
