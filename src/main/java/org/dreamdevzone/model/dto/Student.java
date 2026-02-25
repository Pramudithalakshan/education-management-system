package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Student {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private enum  Gender {
        MALE, FEMALE
    }
    private Gender gender;
    private String address;
    private String phone;
    private Integer parentId;
}
