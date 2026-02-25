package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursesDto {
    private Integer id;
    private String name;
    private String description;
    private Integer teacherId;
    private Integer departmentId;
}
