package br.com.danielferreira.ctrlab.modules.user.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielferreira.ctrlab.modules.user.domain.User;
import br.com.danielferreira.ctrlab.modules.user.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @GetMapping
    List<User> list() {
        return userService.listUsers();
    }

    @GetMapping("{id}")
    Optional<User> getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PutMapping("{id}")
    ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(userService.updateUser(id, user));
    }

    @DeleteMapping("{id}")
    ResponseEntity<User> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(userService.deleteUser(id));
    }

}
