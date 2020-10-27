package com.billreminder.service;

import com.billreminder.domain.User;
import com.billreminder.repository.UserRepository;
import com.billreminder.service.exception.UserExistException;
import com.billreminder.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User addNewUser(User user) throws UserExistException {
        if (userRepository
                .findByNameAndSurnameAndEmail(user.getName(), user.getSurname(), user.getEmail())
                .isPresent() ||
            userRepository.findByEmail(user.getEmail())
                .isPresent()) {
            throw new UserExistException();
        }
        return save(user);
    }

    public void deleteById(Long id) throws UserNotFoundException {
        if (findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
