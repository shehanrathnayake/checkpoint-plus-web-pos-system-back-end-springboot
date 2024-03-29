package com.shehanrathnayake.api;

import com.shehanrathnayake.service.custom.UserService;
import com.shehanrathnayake.to.UserTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserHttpController {

    private final UserService userService;

    public UserHttpController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserTO createNewUser(@RequestBody @Validated UserTO userTO) {
        return userService.saveUser(userTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{user-id}", consumes = "application/json")
    public void updateUser(@PathVariable("user-id") String userId,
                           @RequestBody @Validated UserTO userTO) {
        userTO.setId(userId);
        userService.updateUser(userTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{user-id}")
    public void deleteUser(@PathVariable("user-id") String userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping(value = "/{user-id}", produces = "application/json")
    public UserTO getUserDetails(@PathVariable("user-id") String userId) {
        return userService.getUserDetails(userId);
    }

    @GetMapping(produces = "application/json")
    public List<UserTO> getAllUsers() {
        return userService.getUserList();
    }
}
