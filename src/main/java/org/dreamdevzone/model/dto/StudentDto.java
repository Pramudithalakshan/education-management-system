package org.dreamdevzone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.dreamdevzone.enums.Gender;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private String address;
    private String phone;
    private Integer parentId;
}
