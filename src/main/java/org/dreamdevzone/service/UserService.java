package org.dreamdevzone.service;

import org.dreamdevzone.model.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void add(UserDto  user);
    UserDto get(Integer id);
    List<UserDto> getAll(Pageable pageable);
    void delete(Integer id);
    UserDto update(UserDto user,Integer id);
}
