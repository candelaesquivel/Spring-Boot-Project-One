package com.springBoot.Service;

import com.springBoot.Entity.User;
import com.springBoot.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransaction(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id).map(
                user->{
                    user.setEmail(newUser.getEmail());
                    user.setBirthDay(newUser.getBirthDay());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }
        ).get();
    }
}


