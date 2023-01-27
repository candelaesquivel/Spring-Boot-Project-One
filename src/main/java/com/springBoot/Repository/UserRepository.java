package com.springBoot.Repository;

import com.springBoot.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, String sort);


}
