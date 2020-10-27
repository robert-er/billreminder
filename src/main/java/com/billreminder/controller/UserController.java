package com.billreminder.controller;

import com.billreminder.dto.UserDto;
import com.billreminder.mapper.UserMapper;
import com.billreminder.service.UserService;
import com.billreminder.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userMapper.createUserFromUserDto(userDto)).getId();
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userMapper.mapToUserDtoList(userService.getAll());
    }

    @GetMapping({"id"})
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.mapToUserDto(userService.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @DeleteMapping({"id"})
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.findById(userDto.getId())
                .map(u -> {
                    u.setName(userDto.getName());
                    u.setSurname(userDto.getSurname());
                    u.setEmail(userDto.getEmail());
                    u.setPassword(userDto.getPassword());
                    return userMapper.mapToUserDto(userService.save(u));
                })
                .orElseThrow(UserNotFoundException::new);
    }
}
