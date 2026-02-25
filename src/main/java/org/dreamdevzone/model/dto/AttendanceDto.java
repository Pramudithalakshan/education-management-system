package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.dreamdevzone.enums.Status;

import java.util.Date;
@Getter
@Setter
public class AttendanceDto {
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date date;
    private Status status;

}
