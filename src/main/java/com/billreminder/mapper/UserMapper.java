package com.billreminder.mapper;

import com.billreminder.domain.User;
import com.billreminder.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public User createUserFromUserDto(UserDto userDto) {
        User user = mapToUser(userDto);
        user.setSignUpDate(LocalDateTime.now());
        return user;
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
    }

    public List<UserDto> mapToUserDtoList(List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
