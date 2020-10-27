package com.billreminder.repository;

import com.billreminder.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByNameAndSurnameAndEmail(String name, String surname, String email);

    Optional<User> findByEmail(String email);

}
