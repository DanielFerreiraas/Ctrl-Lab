package br.com.danielferreira.ctrlab.modules.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.danielferreira.ctrlab.exception.BadRequestException;
import br.com.danielferreira.ctrlab.modules.user.domain.User;
import br.com.danielferreira.ctrlab.modules.user.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        Sort sort = Sort.by(Direction.ASC, "username");
        return userRepository.findAll(sort);
    }

    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    public User updateUser(String id, User user) {
        userRepository.findById(id).ifPresentOrElse((existingUser) -> {
            user.setId(id);
            userRepository.save(user);
        }, () -> {
            throw new BadRequestException("User %d não existe! ".formatted(id));
        });

        return user;
    }

    public User deleteUser(String id) {
        userRepository.findById(id).ifPresentOrElse((existingUser) -> userRepository.delete(existingUser), () -> {
            throw new BadRequestException("User %d não existe! ".formatted(id));
        });
        return null;
    }
}
