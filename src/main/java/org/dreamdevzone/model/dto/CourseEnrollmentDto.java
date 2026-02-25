package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CourseEnrollmentDto {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Date date;
}
