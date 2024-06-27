package com.jac.fsd.musicplanet.repositoriy;

import com.jac.fsd.musicplanet.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByUsername(String username);
}
