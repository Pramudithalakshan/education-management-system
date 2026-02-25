package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.dreamdevzone.enums.Gender;

@Getter
@Setter
public class TeacherDto {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
    private String phone;
    private Integer departmentId;
    private Integer teacherId;
}
