package com.github.pedroluiznogueira.securityapi.repository;

import com.github.pedroluiznogueira.securityapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
