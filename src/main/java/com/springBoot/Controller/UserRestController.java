package com.springBoot.Controller;

import com.springBoot.Entity.User;
import com.springBoot.Repository.UserRepository;
import com.springBoot.caseUse.CreateUser;
import com.springBoot.caseUse.DeleteUser;
import com.springBoot.caseUse.GetUser;
import com.springBoot.caseUse.UpdateUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create , get , delete ,update

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;

    private UpdateUser updateUser;

    private UserRepository userRepository;
    public UserRestController(GetUser getUser
            , CreateUser createUser, DeleteUser deleteUser , UpdateUser updateUser ,
                              UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser=createUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;
        this.userRepository=userRepository;
    }

    // localhost:8081/app/api/users/  --> POSTMAN - GET
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    // localhost:8081/app/api/users/  --> POSTMAN -POST
    @PostMapping("/")
    ResponseEntity<User> newUser (@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }
    // localhost:8081/app/api/users/id  --> POSTMAN -DELETE
    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    // localhost:8081/app/api/users/id  --> POSTMAN -PUT
    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser , @PathVariable Long id){
        return updateUser.update(newUser ,id);
    }

    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page , @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }

}
