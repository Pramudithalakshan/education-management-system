package org.dreamdevzone.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.model.dto.UserDto;
import org.dreamdevzone.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public void add(@RequestBody UserDto user) {
        userService.add(user);
    }
    @GetMapping
    public UserDto get(@RequestParam Integer id) {
        return userService.get(id);
    }
    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        userService.delete(id);
    }
    @GetMapping("/getAll")
    public List<UserDto> getAll(Pageable pageable) {
        return userService.getAll(pageable);
    }
    @PostMapping("/{id}")
    public UserDto update(@PathVariable Integer id, @RequestBody UserDto user) {
        return userService.update(user, id);
    }
}
