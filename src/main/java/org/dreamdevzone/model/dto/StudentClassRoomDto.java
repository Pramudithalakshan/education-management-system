package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class StudentClassRoomDto {
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Integer teacherId;
    private Date enrollDate;
}
