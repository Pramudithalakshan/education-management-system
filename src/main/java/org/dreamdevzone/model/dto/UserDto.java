package org.dreamdevzone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private Boolean isActive;
    private String role;
}
