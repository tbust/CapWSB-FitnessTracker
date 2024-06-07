package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;



    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                          .stream()
                          .map(userMapper::toDto)
                          .toList();
    }
    @GetMapping("/{id}")
    public List<UserDto> getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id).stream().map(userMapper::toDto).toList();

    }
    @GetMapping("/by-basic")
    public List<UserDto> getBasicInformationUsersById(@RequestParam("id") Long id)
    {
        return userService.getUser(id).stream().map(userMapper::toDto).toList();
    }
    @GetMapping("/by-email")
    public List<UserDto> getUsersByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email).stream().map(userMapper::toDto).toList();
    }
    @GetMapping("/by-age")
    public List<UserDto> getUsersByAge(@RequestParam("age") int age) {

        return userService.getUsersByAge(age).stream().map(userMapper::toDto).toList();
    }
    @PostMapping("/{firstname}/{lastname}/{birthdate}/{email}")
    public void addUserToDatabase(@PathVariable("firstname") String firstname,
                                  @PathVariable("lastname") String lastname,
                                  @PathVariable("birthdate") LocalDate birthdate,
                                  @PathVariable("email") String email) {

        User user = new User(firstname, lastname, birthdate, email);
        userService.createUser(user);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserFromDatabase(@PathVariable("id") Long id){
        boolean isDeleted = userService.deleteUser(id);

        if(isDeleted){
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}/{firstname}/{lastname}/{birthdate}/{email}")
    public ResponseEntity<UserDto> updateUserInDatabase(@PathVariable Long id, @PathVariable String firstname,
                                                        @PathVariable String lastname, @PathVariable LocalDate birthdate,
                                                        @PathVariable String email) {

        User tmpUser = new User(firstname, lastname, birthdate, email);
        User updatedUser = userService.updateUser(id, tmpUser);

        UserDto userdto = userMapper.toDto(updatedUser);

        return ResponseEntity.ok(userdto);
    }
}