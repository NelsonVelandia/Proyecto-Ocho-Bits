package com.usa.empresa.repository;

import com.usa.empresa.entity.User;
import com.usa.empresa.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NELSON
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAllUser() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getIdUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return usuario.isPresent();
        //return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
    public List<User> listBirthtDayMonth(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
