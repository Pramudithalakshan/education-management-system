package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private enum  Gender {
        MALE, FEMALE
    }
    private Gender gender;
    private String address;
    private String phone;
    private Integer departmentId;
    private Integer teacherId;
}
