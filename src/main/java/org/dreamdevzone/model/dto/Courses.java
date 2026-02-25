package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Courses {
    private Integer id;
    private String name;
    private String description;
    private Integer teacherId;
    private Integer departmentId;
}
