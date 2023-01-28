package com.springBoot.Repository;
import com.springBoot.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User ,Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findName(String name);
    @Query("select u from User u where u.name like ?1%")
    List<User> findNameLike(String name);

    @Query("select u from User u where name = ?1 or email = ?2")
    Optional<User> findUsersByNameOrAndEmail(String name, String email);

    List<User> findAll();



}
