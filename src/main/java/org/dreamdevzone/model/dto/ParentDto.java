package org.dreamdevzone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
